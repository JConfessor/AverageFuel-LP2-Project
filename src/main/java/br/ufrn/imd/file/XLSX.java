package br.ufrn.imd.file;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XLSX {
    private FileInputStream FIS;

    private FormulaEvaluator evaluator;
    private XSSFSheet SH;
    private XSSFWorkbook WB;

    public XLSX(String path) throws IOException, FileNotFoundException {
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

//    public int readXLSX() throws IOException {
//        int lincount = 0;
//        int cont = 0;
//
//        for(Row r: SH){
//            lincount += 1;
//            for(Cell cell : r){
//                if(cont == 0){
//                    cont += 1;
//                }
//                switch(evaluator.evaluateInCell(cell).getCellType()){
//                    case NUMERIC:
//                        System.out.print(cell.getNumericCellValue() + "\t\t");
//                        break;
//
//                    case STRING:
//                        System.out.print(cell.getStringCellValue() + "\t\t");
//                        break;
//
//                    case BOOLEAN:
//                        System.out.print(cell.getBooleanCellValue() + "\t\t");
//                        break;
//
//                    case BLANK:
//                        System.out.print("- \t\t");
//                        break;
//
//                    case ERROR:
//                    case FORMULA:
//                    case _NONE:
//                        break;
//
//                }
//            }
//            System.out.println();
//        }
//
//        WB.close();
//        return lincount;
//
//    }

    public int readXLSX(){

        List<String> nomesJaPassados = new ArrayList<String>();

        for(Row linha: SH){
            if(linha.getRowNum() > 1){


                String nomeCondutor = linha.getCell(10).toString();
                if (!nomesJaPassados.contains(nomeCondutor)) {
                    nomesJaPassados.add(nomeCondutor);
                    //System.out.println(nomeCondutor);
                }
            }
        }

        for(String nome: nomesJaPassados){
            List<Double> unitlts = new ArrayList<Double>();
            List<Double> unitrds= new ArrayList<Double>();
            for(Row l: SH){
                if(l.getRowNum() > 1) {
                    Cell ltt = l.getCell(13);
                    double lt = Float.parseFloat(ltt.toString());

                    Cell rdd = l.getCell(16);
                    double rd = Float.parseFloat(rdd.toString());

                    int match1 = ltt.getColumnIndex() - 3;
                    int match2 = rdd.getColumnIndex() - 6;

                    if (l.getCell(match1).getStringCellValue() == nome) {
                        unitlts.add(lt);
                    }

                    if (l.getCell(match2).getStringCellValue() == nome) {
                        unitrds.add(rd);
                    }
                }
            }

            double sumlts = 0;
            for(double y: unitlts){
                sumlts += y;
            }
            double sumrds = 0;
            for(double y: unitrds){
                sumrds += y;
            }

            System.out.println("[MEDIA] - "+ nome + " - " + (sumrds/sumlts));

        }
        return 0;
    }
}
