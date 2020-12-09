package com.example.demo.util;



import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author txl
 * @description
 * @date 2020/12/7 19:19
 */
public class BeanUtil {
    private static final ModelMapper MODEL_MAPPER = new ModelMapper();

    static {
        // 使用严格模式匹配字段名称来转换
        MODEL_MAPPER.getConfiguration().setFullTypeMatchingRequired(true);
        MODEL_MAPPER.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <T> T copyProperties(Object source, Class<T> clazz) {
        return MODEL_MAPPER.map(source, clazz);
    }

    public static void copyProperties(Object source, Object destination) {
        MODEL_MAPPER.map(source, destination);
    }

    public static <T> T copyProperties(Object source, Type destinationType) {
        return MODEL_MAPPER.map(source, destinationType);
    }

    public static <D, T> List<D> copyCollections(final Collection<T> entityList, Class<D> outClass) {
        return entityList.stream()
                .map(entity -> copyProperties(entity, outClass))
                .collect(Collectors.toList());
    }
}
