package com.example.pengadaanrsudsamrat.order.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DailyExpenseDTO {
    private LocalDateTime date;
    private BigDecimal totalExpense;

    // Constructor, getters, and setters
}

