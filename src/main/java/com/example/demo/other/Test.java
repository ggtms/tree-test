package com.example.demo.other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author txl
 * @description
 * @date 2021/6/16 19:41
 */
public class Test {
    public static void main(String[] args) {
        String sql = "update student set name = $.name ,set phone = $.phone";
        Map<String, String> map = new HashMap<>(20);
        map.put("$.name", "Morrison");
        map.put("$.phone", "1232423432");
        StringBuffer s = new StringBuffer(sql);
        map.forEach((key, value) ->
            s.replace(0, s.capacity(), s.toString().replace(key, value))
        );
        System.out.println(s);
    }

}
