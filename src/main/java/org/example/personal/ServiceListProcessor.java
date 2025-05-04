package org.example.personal;

import java.util.*;
import java.util.stream.Collectors;

public class ServiceListProcessor {
    public static void main(String[] args) {
        List<Map<String, Object>> serviceList = new ArrayList<>();

        // Sample data
        serviceList.add(createService("Factiva Check", "PENDING", "FACTIVA"));
        //serviceList.add(createService("Factiva Check", "PENDING", "FACTIVA"));

        serviceList.add(createService("Internal Dedupe Check", "PENDING", "INTERNAL_DEDUPE"));
        serviceList.add(createService("Posidex Check", "PENDING", "POSIDEX"));
        //serviceList.add(createService("Internal Dedupe Check", "COMPLETED", "INTERNAL_DEDUPE"));

        serviceList.add(createService("Bureau Check", "PENDING", "MULTI_BUREAU"));

        List<Map<String, Object>> filteredList = removeDuplicateServices(serviceList);

        // Print result
        filteredList.forEach(System.out::println);
    }

    private static Map<String, Object> createService(String name, String status, String code) {
        Map<String, Object> service = new HashMap<>();
        service.put("service_name_value", name);
        service.put("status_message", status);
        service.put("service_name_code", code);
        return service;
    }

    public static List<Map<String, Object>> removeDuplicateServices(List<Map<String, Object>> serviceList) {
        Map<String, Map<String, Object>> uniqueServices = new HashMap<>();

        for (Map<String, Object> service : serviceList) {
            String serviceCode = (String) service.get("service_name_code");
            String status = (String) service.get("status_message");

            if (!uniqueServices.containsKey(serviceCode) || "COMPLETED".equals(status)) {
                uniqueServices.put(serviceCode, service);
            }
        }

        return new ArrayList<>(uniqueServices.values());
    }
}

