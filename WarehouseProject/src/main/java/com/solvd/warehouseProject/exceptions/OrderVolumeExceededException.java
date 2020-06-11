package com.solvd.warehouseProject.exceptions;

import java.io.IOException;

public class OrderVolumeExceededException extends IOException {
    public OrderVolumeExceededException(String message) {
        super(message);
    }
}
