package br.ufrn.imd.file;

import br.ufrn.imd.vehicle.EscortVehicle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.lang.model.element.ElementVisitor;
import java.io.FileInputStream;
import java.io.IOException;

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

    public int readXLSX() throws IOException {
        int denyHeader = 0;
        Map<String, EscortVehicle> ListEscortVehicle = new HashMap<>();
        for(Row r: SH){
            if(denyHeader == 0){
                denyHeader += 1;
            }else{
                EscortVehicle EVehicle = new EscortVehicle();
                EVehicle.setLicensePlate(r.getCell(4).toString());
                EVehicle.setVehicleModel(r.getCell(6).toString());
                EVehicle.setLicensePlate(r.getCell(4).toString());
            }
        }

        WB.close();
        return 0;

    }
}
