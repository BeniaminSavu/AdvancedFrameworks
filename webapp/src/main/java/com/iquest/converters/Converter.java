package com.iquest.converters;

public interface Converter<T1, T2> {

	T2 convertToData(T1 model);

	T1 convertToModel(T2 data);

}
