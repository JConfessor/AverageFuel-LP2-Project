package br.ufrn.imd.file;

import br.ufrn.imd.vehicle.EscortVehicle;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellBase;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.lang.model.element.ElementVisitor;
import java.io.FileInputStream;
import java.io.IOException;

import java.sql.ClientInfoStatus;
import java.util.*;

public class XLSX {
    private final FileInputStream FIS;
    private FormulaEvaluator evaluator;
    private XSSFSheet SH;
    private XSSFWorkbook WB;

    public XLSX(String path) throws IOException {
      this.FIS =  new FileInputStream(path);
      openXLSX();
    }
    private void openXLSX() throws IOException{
        // Creating XSSF workbook
        this.WB = new XSSFWorkbook(FIS);

        // Creating sheet
        this.SH =  WB.getSheetAt(0);

        // Evaluating sheet
        this.evaluator = WB.getCreationHelper().createFormulaEvaluator();
    }

    public Map readXLSX() throws IOException {
        Map<String, EscortVehicle> ListEscortVehicle = new HashMap<>();

        List<String> Forbidden = new ArrayList<>(Arrays.asList("PROPRIA", "ND", ""));

        for(Row r: SH) {
            if (r.getRowNum() > 1 && !Forbidden.contains(r.getCell(7).toString())) {
                EscortVehicle EVehicle = new EscortVehicle(r.getCell(4).toString(), r.getCell(6).toString(), r.getCell(7).toString());
                ListEscortVehicle.put(r.getCell(4).toString(), EVehicle);
            }else{
                System.out.println("Error 1");
            }
        }

        for(Row r: SH) {
            if (r.getRowNum() > 1 && !Forbidden.contains(r.getCell(7).toString())) {
                EscortVehicle EVehicle = ListEscortVehicle.get(r.getCell(4).toString());
                EVehicle.setMonthlyOdometer((int) r.getCell(16).getNumericCellValue());
                EVehicle.setLiters(r.getCell(13).getNumericCellValue());
                EVehicle.setTotalCost(r.getCell(18).getNumericCellValue());
                EVehicle.setAverageLtCost(0);
            }else{
                System.out.println("Error 2");
            }

        }

        WB.close();
        return ListEscortVehicle;

    }
}
