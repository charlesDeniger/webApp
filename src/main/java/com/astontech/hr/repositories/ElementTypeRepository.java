package com.astontech.hr.repositories;

import com.astontech.hr.domain.Element;
import com.astontech.hr.domain.ElementType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by chardeni1 on 8/5/2016.
 */
public interface ElementTypeRepository extends CrudRepository<ElementType,Integer> {
    ElementType findByElementTypeName(String elementTypeName);

    List<ElementType> findAllByElementTypeName(String elementTypeName);

    List<Element> findAllElementsById(Integer id);

    List<ElementType> findAllByElementTypeNameIgnoreCase(String elementTypeName);

    List<ElementType> findDistinctElementTypeByElementTypeName(String elementTypeName);

    List<ElementType> findFirst3ByElementTypeName(String elementTypeName);
}
