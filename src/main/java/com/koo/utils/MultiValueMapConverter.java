package com.koo.utils;

import com.koo.book.domain.category.Category;
import com.koo.utils.exception.CannotMapConvertException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class MultiValueMapConverter {

	public static MultiValueMap<String, String> convert(Object object) {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

		Field[] fields = object.getClass().getDeclaredFields();

		Map<String, String> collect = Arrays.stream(fields)
			.filter(field -> {
				Object value = getValue(object, field);
				if (value == null) {
					return false;
				} else {
					return true;
				}
			})
			.collect(Collectors.toMap(field -> field.getName(), field -> String.valueOf(getValue(object, field))));

		map.setAll(collect);
		return map;
	}

	private static Object getValue(Object object, Field field) {
		try {
			return new PropertyDescriptor(field.getName(), object.getClass()).getReadMethod().invoke(object);
		} catch (IllegalAccessException | IntrospectionException | InvocationTargetException e) {
			throw new CannotMapConvertException("map 으로 변경 중 오류 발생");
		}
	}
}
