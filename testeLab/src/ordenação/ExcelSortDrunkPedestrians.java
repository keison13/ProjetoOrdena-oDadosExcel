package ordenação;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.CellType;

import algoritimos.InsertionSort;
import algoritimos.HeapSort;
import algoritimos.CountingSort;
import algoritimos.MergeSort;
import algoritimos.QuickSort;
import algoritimos.QuickSortMedianOfThree;
import algoritimos.SelectionSort;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.util.Date;
import java.util.stream.Collectors;

public class ExcelSortDrunkPedestrians {
	 public static void main(String[] args) throws IOException {
	        String inputFile = "C:\\projeto java\\ws-eclipse\\ArquivosProjetoOrdenação\\drunk_pedestrians.csv.xlsx";
	        String outputInsertionSortFile1 = "C:\\projeto java\\ws-eclipse\\ArquivosProjetoOrdenação\\drunk_pedestrians_unnamed_insertionSort_melhorCaso.csv.xlsx";

	        // Leitura da coluna a ser ordenada
	        List<Integer> unnamedColumn = readColumnFromExcel(inputFile, 0, ExcelColumnType.INTEGER);
	        
	        int[] unnamedArray = unnamedColumn.stream().mapToInt(Integer::intValue).toArray();
	        
	        // Execução do Insertion Sort e impressão do tempo de execução
	        System.out.println("Ordenação usando Insertion Sort:");
	        double insertionSortTime = InsertionSort.sort(unnamedArray);
	        System.out.println("Tempo de execução da ordenação InsertionSort(data): " + insertionSortTime + " segundos");
	        
	        // Salvando os dados ordenados pelo Insertion Sort em um novo arquivo Excel
	        List<Integer> unnamedData = Arrays.asList(Arrays.stream(unnamedArray).boxed().toArray(Integer[]::new));
	        writeColumnToExcel(outputInsertionSortFile1, unnamedData, 0);
	        System.out.println("Dados ordenados pelo InsertionSort(data) salvos em " + outputInsertionSortFile1);
	        

	     // Re-leitura da coluna para realizar as outras ordenações
	        
	        unnamedColumn = readColumnFromExcel(inputFile, 0, ExcelColumnType.INTEGER);
	        unnamedArray = unnamedColumn.stream().mapToInt(Integer::intValue).toArray();
	        

	        // Execução do Selection Sort e impressão do tempo de execução
	        System.out.println("\nOrdenação usando Selection Sort:");
	        double selectionSortTime = SelectionSort.sort(unnamedArray);
	        System.out.println("Tempo de execução da ordenação SelectionSort(data): " + selectionSortTime + " segundos");

	        // Execução do Merge Sort e impressão do tempo de execução
	        System.out.println("\nOrdenação usando Merge Sort:");
	        double mergeSortTime = MergeSort.sort(unnamedArray);
	        System.out.println("Tempo de execução da ordenação MergeSort(data): " + mergeSortTime + " segundos");

	        // Execução do Quick Sort e impressão do tempo de execução
	        System.out.println("\nOrdenação usando Quick Sort:");
	        double quickSortTime = QuickSort.sort(unnamedArray);
	        System.out.println("Tempo de execução da ordenação QuickSort(data): " + quickSortTime + " segundos");

	        
	    }

	 public static List<Date> readDateColumnFromExcel(String filePath, int columnIndex) throws IOException {
	        List<Date> columnData = new ArrayList<>();
	        FileInputStream fis = new FileInputStream(new File(filePath));
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheetAt(0);

	        for (Row row : sheet) {
	            Cell cell = row.getCell(columnIndex);
	            if (cell != null && cell.getCellType() == CellType.NUMERIC && DateUtil.isCellDateFormatted(cell)) {
	                columnData.add(cell.getDateCellValue());
	            }
	        }

	        workbook.close();
	        fis.close();
	        return columnData;
	    }

	    public static <T> List<T> readColumnFromExcel(String filePath, int columnIndex, ExcelColumnType columnType) throws IOException {
	        List<T> columnData = new ArrayList<>();
	        FileInputStream fis = new FileInputStream(new File(filePath));
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheetAt(0);

	        for (Row row : sheet) {
	            Cell cell = row.getCell(columnIndex);
	            if (cell != null) {
	                switch (columnType) {
	                    case INTEGER:
	                        if (cell.getCellType() == CellType.NUMERIC) {
	                            columnData.add((T) (Integer.valueOf((int) cell.getNumericCellValue())));
	                        }
	                        break;
	                    case STRING:
	                        if (cell.getCellType() == CellType.STRING) {
	                            columnData.add((T) cell.getStringCellValue());
	                        }
	                        break;
	                }
	            }
	        }

	        workbook.close();
	        fis.close();
	        return columnData;
	    }

	    public static void writeColumnToExcel(String filePath, List<?> data, int columnIndex) throws IOException {
	        FileInputStream fis = new FileInputStream(new File(filePath));
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheetAt(0);

	        for (int i = 0; i < data.size(); i++) {
	            Row row = sheet.getRow(i);
	            if (row == null) row = sheet.createRow(i);
	            Cell cell = row.createCell(columnIndex);
	            cell.setCellValue(data.get(i).toString());
	        }

	        fis.close();

	        FileOutputStream fos = new FileOutputStream(new File(filePath));
	        workbook.write(fos);
	        fos.close();

	        workbook.close();
	    }

	    public enum ExcelColumnType {
	        INTEGER, STRING
	    }
	}
