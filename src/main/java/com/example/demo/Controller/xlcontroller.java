package com.example.demo.Controller;

import com.example.demo.Entity.xlentity;
import com.example.demo.Repository.xlrepository;
import jakarta.annotation.Nullable;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
public class xlcontroller {

    @Autowired
    private xlrepository repo;
    DataFormatter formatter = new DataFormatter();

    public String cellTypeConveter(Cell c) {
        return formatter.formatCellValue(c);
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<Optional<xlentity>> getUserData(@PathVariable("id") Long id) {
        Optional<xlentity> user = repo.findById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/api/excel-save")
    public ResponseEntity<List<xlentity>> handleExcelRequest(@RequestParam("excelFile") MultipartFile excelFile) throws IOException {
        List<xlentity> data = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(excelFile.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        for (int i = 0; i <= sheet.getPhysicalNumberOfRows() - 1; i++) {
            xlentity xl1 = new xlentity();
            try {
                @Nullable
                xlentity isUserExists;
                isUserExists = repo.findByUser(cellTypeConveter(sheet.getRow(i + 1).getCell(0)), cellTypeConveter(sheet.getRow(i + 1).getCell(1)), cellTypeConveter(sheet.getRow(i + 1).getCell(2)), cellTypeConveter(sheet.getRow(i + 1).getCell(3)), cellTypeConveter(sheet.getRow(i + 1).getCell(4)), cellTypeConveter(sheet.getRow(i + 1).getCell(5)), cellTypeConveter(sheet.getRow(i + 1).getCell(6)), cellTypeConveter(sheet.getRow(i + 1).getCell(7)), cellTypeConveter(sheet.getRow(i + 1).getCell(8)), cellTypeConveter(sheet.getRow(i + 1).getCell(9)));
                System.out.println("isUserExists-------" + isUserExists.toString());
                if (!(isUserExists == null)) {
                    xl1.setProductCode(cellTypeConveter(sheet.getRow(i + 1).getCell(0)));
                    xl1.setProductName(cellTypeConveter(sheet.getRow(i + 1).getCell(1)));
                    xl1.setPeriod(cellTypeConveter(sheet.getRow(i + 1).getCell(2)));
                    xl1.setPlan(cellTypeConveter(sheet.getRow(i + 1).getCell(3)));
                    xl1.setZone(cellTypeConveter(sheet.getRow(i + 1).getCell(4)));
                    xl1.setPincode(cellTypeConveter(sheet.getRow(i + 1).getCell(5)));
                    xl1.setPed(cellTypeConveter(sheet.getRow(i + 1).getCell(6)));
                    xl1.setDeduction(cellTypeConveter(sheet.getRow(i + 1).getCell(7)));
                    xl1.setOdPerc(cellTypeConveter(sheet.getRow(i + 1).getCell(8)));
                    xl1.setSumInsured(cellTypeConveter(sheet.getRow(i + 1).getCell(9)));
                    repo.save(xl1);
                } else {
                    System.out.println("duplicateEntryFound");
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
            data.add(xl1);
        }
        return ResponseEntity.ok(data);
    }


}
