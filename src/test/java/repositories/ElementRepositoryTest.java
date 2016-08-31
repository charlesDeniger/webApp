package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by chardeni1 on 8/5/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementRepositoryTest {

    @Autowired
    private ElementRepository elementRepository;

    //region oldtests
//    @Test
//    public void testSaveElement() {
//        Element element = new Element();
//        element.setElementName("Phone");
//
//        //save element, verify it has an ID after the save.
//
//        assertNull(element.getId());
//        elementRepository.save(element);
//        assertNotNull(element.getId());
//
//        //fetch
//        Element fetchedElement = elementRepository.findOne(element.getId());
//        assertNotNull(fetchedElement);
//        assertEquals(element.getId(), fetchedElement.getId());
//
//        //update
//        fetchedElement.setElementName("Email");
//        elementRepository.save(fetchedElement);
//
//        Element updatedElement = elementRepository.findOne(fetchedElement.getId());
//        assertEquals(updatedElement.getElementName(), "Email");
//    }
//    @Test
//    public void testSaveElementList() {
//        List<Element> elementList = new ArrayList<>();
//        elementList.add(new Element("phone"));
//        elementList.add(new Element("email"));
//        elementList.add(new Element("laptop"));
//        elementList.add(new Element("PayRate"));
//
//        elementRepository.save(elementList);
//        Iterable<Element> fetchedElementList = elementRepository.findAll();
//
//        int count = 0;
//        for (Element element : fetchedElementList) {
//            count++;
//        }
////        assertEquals(5, count);
//    }
//
//    @Test
//    public void testFindByName() {
//        Element element = new Element("FindTestSingle");
//        elementRepository.save(element);
//
//        Element foundByNameElement = elementRepository.findByElementName("FindTestSingle");
//        assertEquals(element.getId(), foundByNameElement.getId());
//    }
//
//    @Test
//    public void testFindAllByName() {
//        Element element = new Element("FindTest");
//        elementRepository.save(element);
//        Element element1 = new Element("FindTest");
//        elementRepository.save(element1);
//        Element element2 = new Element("FindTest");
//        elementRepository.save(element2);
//        Element element3 = new Element("FindTest");
//        elementRepository.save(element3);
//
//
//        List<Element> foundByNameElement = elementRepository.findAllByElementName("FindTest");
//
//        assertEquals(4, foundByNameElement.size());
//    }
    //endregion
//
//    @Test
//    public void testFindDistinctElementByElementName() {
//        Element element = new Element("Test");
//        elementRepository.save(element);
//        Element element1 = new Element("Test");
//        elementRepository.save(element1);
//        Element element2 = new Element("Test");
//        elementRepository.save(element2);
//        Element element3 = new Element("Test");
//        elementRepository.save(element3);
//
//
//        List<Element> foundByNameElement = elementRepository.findDistinctElementByElementName("Test");
//
//
//
////        System.out.println(foundByNameElement.getElementName());
//
//        for (Element element4 : foundByNameElement) {
//            System.out.println(element4.getElementName());
//        }
//    }
//
//    @Test
//    public void testFindElementDescriptionByElementName() {
//        Element element = new Element("Test1");
//        element.setElementDescription("asfd;a;lsdkf;laksdjf");
//        elementRepository.save(element);
//        Element element1 = new Element("Test2");
//        element.setElementDescription(";asd;lkrwelkrjl;sdkf");
//        elementRepository.save(element1);
//        Element element2 = new Element("Test3");
//        element.setElementDescription("adwsfjlkadsjf;asd");
//        elementRepository.save(element2);
//        Element element3 = new Element("Test4");
//        element.setElementDescription("asd;lkfjwe2krmf;asdlkf");
//        elementRepository.save(element3);
//
//        Element foundByDescription = elementRepository.findElementDescriptionByElementName("Test1");
//        System.out.println(foundByDescription.getElementDescription());
//    }
//
//    @Test
//    public void testFindTop3ElementByElementDesc() {
//        Element element = new Element("Test");
//        elementRepository.save(element);
//        Element element1 = new Element("Test");
//        elementRepository.save(element1);
//        Element element2 = new Element("Test");
//        elementRepository.save(element2);
//        Element element3 = new Element("Test");
//        elementRepository.save(element3);
//
//        List<Element> elementList = elementRepository.findFirst3ByElementName("Test");
//
//        for (Element e : elementList) {
//            System.out.println(e.getElementName() + " " + e.getElementDescription());
//        }
//    }
}
