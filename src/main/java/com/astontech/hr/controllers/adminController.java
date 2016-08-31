package com.astontech.hr.controllers;

import com.astontech.hr.domain.*;
import com.astontech.hr.domain.VO.ElementVO;
import com.astontech.hr.domain.VO.VehicleVO;
import com.astontech.hr.services.ElementTypeService;
import com.astontech.hr.services.VehicleMakeService;
import com.astontech.hr.services.VehicleModelService;
import com.astontech.hr.services.VehicleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;


/**
 * Created by chardeni1 on 8/9/2016.
 */
@Controller
public class adminController {

    @Autowired
    private ElementTypeService elementTypeService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleModelService vehicleModelService;

    @Autowired
    private VehicleMakeService vehicleMakeService;


    private Logger log = Logger.getLogger(adminController.class);
    int highest =0;


    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminHome() {

        return "admin/element/adminHome";
    }

    //region Element
    @RequestMapping(value = "/admin/element/add", method = RequestMethod.GET)
    public String adminElementGet(Model model) {
        model.addAttribute("elementVO", new ElementVO());
        model.addAttribute("warningAlert", "visible");
        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/add", method = RequestMethod.POST)
    public String adminElementPost(ElementVO elementVO, Model model) {
        elementVO.splitNewElementsIntoArray();
        logElementVO(elementVO);
        saveElementTypesFromVO(elementVO);

        boolean success = true;
        if (success) {
            model.addAttribute("successAlert", "visible");
        }else
            model.addAttribute("errorAlert", "visible");

        model.addAttribute("elementVO", new ElementVO());

        return "admin/element/element_add";
    }

    @RequestMapping(value = "/admin/element/list", method = RequestMethod.GET)
    public String adminElementList(Model model) {
        model.addAttribute("elementTypeList", elementTypeService.listAllElementTypes());
        return "admin/element/element_list";
    }

    @RequestMapping(value = "/admin/element/edit/{id}", method = RequestMethod.GET)
    public String elementTypeEdit(@PathVariable int id, Model model) {


        ElementType elementType = elementTypeService.getElementTypeById(id);

        model.addAttribute("elementType", elementType);
        return "admin/element/element_edit";
    }
    @RequestMapping(value="/admin/element/delete/{id}", method = RequestMethod.GET)
    public String elementTypeDelete(@PathVariable int id) {
        elementTypeService.deleteElementType(id);
        return "redirect:/admin/element/list";
    }

    @RequestMapping(value = "/admin/element/update", method =RequestMethod.POST)
    public String elementTypeUpdate(ElementType elementType,
                                    Model model,
                                    @RequestParam("inputNewElement") String newElement){
        //notes:    if newElement (unbound text box) has a value, add it to list
        if(!newElement.equals("")) {
            if (elementType.getElementList() == null) {
                List<Element> elementList = new ArrayList<Element>();
                elementList.add(new Element(newElement));
                elementType.setElementList(elementList);
            }else {
                elementType.getElementList().add(new Element(newElement));
            }
        }

        //notes:    iterate thru the list of elements
        for (int i = 0; i < elementType.getElementList().size(); ++i) {
            //notes:    check to see if element name is empty
            if (elementType.getElementList().get(i).getElementName().equals("")) {
                //notes:    element name is blank remove it from the list
                elementType.getElementList().remove(i);
            }

        }

        elementTypeService.saveElementType(elementType);
        model.addAttribute("successAlert", "visible");
        return "redirect:/admin/element/edit/" + elementType.getId();
    }
    //endregion

    //========================================================================
    //-----------------          Vehicle Controller         ------------------
    //========================================================================

    @RequestMapping(value = "/admin/vehicle", method = RequestMethod.GET)
    public String getVehicle(Model model) {
//        VehicleVO vehicleVO = new VehicleVO();
        model.addAttribute("VehicleVO", new VehicleVO());
//        setVehicleListsFromVO(vehicleVO);
        Iterable<VehicleMake> vehicleMakes = new ArrayList<VehicleMake>();
        List<String> vehicleMakeNames = new ArrayList<>();
        for (VehicleMake vehicleMakeName : vehicleMakes) {
            vehicleMakeNames.add(vehicleMakeName.getVehicleMakeName());
        }
        model.addAttribute("newVehicleMakes", vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("newVehicleModels", vehicleModelService.listAllVehicleModels());

        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle", method = RequestMethod.POST)
    public String adminVehiclePost(Model model,
                                   VehicleVO vehicleVO) {

        model.addAttribute("VehicleVO", vehicleVO);

        boolean success = true;
        saveVehiclefromVO(vehicleVO);

        if (success) {
            model.addAttribute("successAlert", "visible");
        }else
            model.addAttribute("errorAlert", "visible");
        model.addAttribute("VehicleVO", new VehicleVO());
        model.addAttribute("newVehicleMakes", vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("newVehicleModels", vehicleModelService.listAllVehicleModels());

         //need this to save vehicle


        return "admin/vehicle/vehicle_add";
    }

    @RequestMapping(value = "/admin/vehicle_list", method = RequestMethod.GET)
    public String getVehicleList(Model model) {
        List<VehicleVO> vehicleVOList = new ArrayList<VehicleVO>();
        for(Vehicle vehicle : vehicleService.listAllVehicles()) {
            VehicleVO vehicleVO = new VehicleVO();
            vehicleVO.setVehicle(vehicle);
            vehicleVO.setVehicleModel(vehicleModelService.findVehicleModelByVehicleId(vehicle.getId()));
            vehicleVOList.add(vehicleVO);
        }

        model.addAttribute("vehicleVOList", vehicleVOList);
        return "admin/vehicle/vehicle_list";
    }

    @RequestMapping(value = "/admin/vehicle_models/{id}", method = RequestMethod.GET)
    public String getVehicleModelList(@PathVariable int id,
                                      Model model) {
        VehicleModel vehicleModel = new VehicleModel(vehicleMakeService.getVehicleMakeById(id));
        model.addAttribute("vehicleModel", vehicleModel);
        model.addAttribute("vehicleModelList", findModelsByMake(id));
        return "admin/vehicle/vehicle_models";
    }

    @RequestMapping(value = "/admin/vehicle_models/update", method = RequestMethod.POST)
    public String execVehicleModelsList(VehicleModel vehicleModel,
                                        Model model,
                                        @RequestParam String vmakeId,
                                        @RequestParam String inputNewModel,
                                        @RequestParam(required=false) String ids) {
//        System.out.println(inputNewModel);


        int x = Integer.parseInt(vmakeId);

        if (!inputNewModel.equals("")) {

            if (findModelsByMake(x) == null) {
                List<VehicleModel> vehicleModelList = new ArrayList<VehicleModel>();
                vehicleModelList.add(new VehicleModel(inputNewModel, vehicleMakeService.getVehicleMakeById(x)));
            } else {

                VehicleModel vehicleModel1 = new VehicleModel(inputNewModel, vehicleMakeService.getVehicleMakeById(x));
                vehicleModelService.saveVehicleModel(vehicleModel1);
            }
        }
        else
            {
                System.out.println(ids);
                List<String> vehicleList = new ArrayList<String>();
                List<String> idList = new ArrayList<String>();
                List<Integer> newIdList = new ArrayList<Integer>();

                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder idBuilder = new StringBuilder();
                idBuilder.append(ids);
                StringBuilder newName = new StringBuilder();
                StringBuilder newId = new StringBuilder();
                stringBuilder.append(vehicleModel.getVehicleModelName());
                stringBuilder.append(","+inputNewModel);
                System.out.println(stringBuilder);
                for (int i =0; i<stringBuilder.length(); ++i) {
                    if (stringBuilder.charAt(i) == ',') {
                            vehicleList.add(newName.toString());
                            newName.delete(0,i);
                    } else {
                        newName.append(stringBuilder.charAt(i));
                    }

                }

                for (int i = 0; i<idBuilder.length(); ++i) {
                    if (idBuilder.charAt(i) == ',') {
                        idList.add(newId.toString());
                        newId.delete(0,i);
                    } else {
                        newId.append(idBuilder.charAt(i));
                    }

                }
                int lastModel =Integer.parseInt(idList.get(idList.size()-1))+1;
                for (String s : idList) {
                    newIdList.add(Integer.parseInt(s));
                }
                newIdList.add(lastModel);

                for (String s : vehicleList) {
                    System.out.println(s);
                }
                System.out.println(newIdList.size());
                for (int i = 0; i < newIdList.size(); ++i) {

                   vehicleModel = vehicleModelService.getVehicleModelById(newIdList.get(i));
                    vehicleModel.setVehicleModelName(vehicleList.get(i));
                    vehicleModelService.saveVehicleModel(vehicleModel);
                }
            }
        model.addAttribute("successAlert", "visible");
        return "redirect:/admin/vehicle_models/"+ x;
    }
    @RequestMapping(value = "/admin/vehicle_makes/update", method = RequestMethod.POST)
    public String execVehicleMakeUpdate(@RequestParam String inputNewMake,
                                        @RequestParam(required=false) String ids,
                                        VehicleMake vehicleMake,
                                        Model model) {

        System.out.println(vehicleMake.getVehicleMakeName());
        System.out.println(vehicleMake.getId());
        System.out.println(inputNewMake);

        if (!inputNewMake.equals("")) {
            VehicleMake vehicleMake1 = new VehicleMake();
            vehicleMake1.setVehicleMakeName(inputNewMake);
            vehicleMakeService.saveVehicleMake(vehicleMake1);
        } else {

        }
        System.out.println(ids);




        return "redirect:/admin/vehicle_makes";
    }

    @RequestMapping(value = "/admin/vehicle_models/delete/{makeId}/{id}", method = RequestMethod.GET)
    public String execVehicleModelDelete(@PathVariable int id,
                                         @PathVariable int makeId,
                                         Model model) {


        for (Vehicle vehicle : vehicleService.listAllVehicles()) {
            if (vehicle.getVehicleModel().getId()==id) {
                vehicleService.deleteVehicle(vehicle.getId());
            }
        }

        vehicleModelService.deleteVehicleModel(id);
        return "redirect:/admin/vehicle_models/{makeId}";
    }

    @RequestMapping(value = "/admin/vehicle_makes/delete/{makeId}", method = RequestMethod.GET)
    public String execVehicleMakeDelete(@PathVariable int makeId,
                                         Model model) {
        for (VehicleModel vehicleModel : vehicleModelService.listAllVehicleModels()) {
            if (vehicleModel.getVehicleMake().getId() == makeId) {
                for (Vehicle vehicle : vehicleService.listAllVehicles()) {
                    if (vehicle.getVehicleModel().getId() == vehicleModel.getId()) {
                        vehicleService.deleteVehicle(vehicle.getId());
                    }
                }
               vehicleModelService.deleteVehicleModel(vehicleModel.getId());
            }
        }
        vehicleMakeService.deleteVehicleMake(makeId);
        return "redirect:/admin/vehicle_makes";
    }

    @RequestMapping(value = "/admin/vehicle_makes", method = RequestMethod.GET)
    public String getVehicleMakeList(Model model) {

        Iterable<VehicleMake> vehicleMakes = vehicleMakeService.listAllVehicleMakes();
        VehicleVO vehicleVO = new VehicleVO();
        vehicleVO.setVehicleMakeIterable(vehicleMakes);

        model.addAttribute("vehicleMakeList", vehicleMakes);
        model.addAttribute("VehicleMake", new VehicleMake());

        return "admin/vehicle/vehicle_makes";
    }

    @RequestMapping(value = "/admin/vehicle/edit/{id}", method = RequestMethod.GET)
    public String vehicleEdit(@PathVariable int id,
                              Model model) {

        model.addAttribute("vehicle", vehicleService.getVehicleById(id));
        model.addAttribute("vehicleMakes", vehicleMakeService.listAllVehicleMakes());
        model.addAttribute("vehicleModels", vehicleModelService.listAllVehicleModels());

        return "admin/vehicle/vehicle_edit";
    }

    @RequestMapping(value = "/admin/vehicle/update", method = RequestMethod.POST)
    public String vehicleUpdate(Model model,Vehicle vehicle) {

        Vehicle vehicle1 = vehicleService.getVehicleById(vehicle.getId());
        vehicle1.setColor(vehicle.getColor());
        vehicle1.setYear(vehicle.getYear());
        vehicle1.setVIN(vehicle.getVIN());
        vehicle1.setLicensePlate(vehicle.getLicensePlate());
        vehicle1.setVehicleModel(vehicle.getVehicleModel());
        vehicleService.saveVehicle(vehicle1);

        return "redirect:/admin/vehicle/edit/" + vehicle1.getId();
    }

    @RequestMapping(value = "/admin/vehicle/delete/{id}", method = RequestMethod.GET)
    public String vehicleListDelete(@PathVariable int id,
                              Model model) {

        vehicleService.deleteVehicle(id);


        return "redirect:/admin/vehicle_list";
    }



    //region HELPER METHODS


    private void saveElementTypesFromVO(ElementVO elementVo) {

        List<Element> newElementList = new ArrayList<Element>();
        for (String str : elementVo.getNewElementArray()) {
            newElementList.add(new Element(str));
        }
        ElementType newElementType = new ElementType(elementVo.getNewElementType());
        newElementType.setElementList(newElementList);

        elementTypeService.saveElementType(newElementType);
    }
    public List<VehicleModel> findModelsByMake(int makeId) {
        Iterable<VehicleModel> vehicleModels = vehicleModelService.listAllVehicleModels();
        List<VehicleModel> specificList = new ArrayList<VehicleModel>();
        for (VehicleModel vehicleModel : vehicleModels) {
            if (vehicleModel.getVehicleMake().getId() == makeId) {
                specificList.add(vehicleModel);
            }
        }
        return specificList;
    }

    private void saveVehiclefromVO(VehicleVO vehicleVO) {
//        VehicleModel vehicleModel = new VehicleModel(vehicleVO.getVehicle().getVehicleModel().getVehicleModelName(), vehicleVO.getVehicle().getVehicleModel().getVehicleMake());
        Vehicle vehicle = new Vehicle(vehicleVO.getVehicle().getVehicleModel(), vehicleVO.getVehicle().getYear(), vehicleVO.getVehicle().getLicensePlate(), vehicleVO.getVehicle().getVIN(), vehicleVO.getVehicle().getColor());


        vehicleService.saveVehicle(vehicle);

    }

    private void updateVehicle(Vehicle vehicle) {

        vehicleService.saveVehicle(vehicle);
    }


    private void logElementVO(ElementVO elementVO) {
        log.info("New Element Type: "+ elementVO.getNewElementType());
            for (String str : elementVO.getNewElementArray()) {
                log.info("New Element: "+ str);
            }
        }
    //endregion

    }
