package com.example.myhotel.DTO;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

public @Data class ResponsData <T> {
    private boolean status;
    private List<String> message = new ArrayList<>();
    private T payload;
}
