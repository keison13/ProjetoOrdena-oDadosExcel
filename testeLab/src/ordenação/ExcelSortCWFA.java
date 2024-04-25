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

public class ExcelSortCWFA {
	 public static void main(String[] args) throws IOException {
	        String inputFile = "C:\\projeto java\\ws-eclipse\\ArquivosProjetoOrdenação\\accidents_CWFA.csv.xlsx";
	        String outputInsertionSortFile1 = "C:\\projeto java\\ws-eclipse\\ArquivosProjetoOrdenação\\accidents_CWFA_data_insertionSort_melhorCaso.csv.xlsx";
	        String outputInsertionSortFile2 = "C:\\projeto java\\ws-eclipse\\ArquivosProjetoOrdenação\\accidents_CWFA_time_insertionSort_melhorcaso.csv.xlsx";
	        String outputInsertionSortFile3 = "C:\\projeto java\\ws-eclipse\\ArquivosProjetoOrdenação\\accidents_CWFA_communication_kind_insertionSort_melhorCaso.csv.xlsx";

	        // Leitura da coluna a ser ordenada
	        List<Date> dataColumn = readDateColumnFromExcel(inputFile, 1);
	        List<Integer> timeColumn = readColumnFromExcel(inputFile, 2, ExcelColumnType.INTEGER);
	        List<String> communicationKindColumn = readColumnFromExcel(inputFile, 0, ExcelColumnType.STRING);
	        
	        int[] dataArray = dataColumn.stream().mapToInt(date -> (int) date.getTime()).toArray();
	        int[] timeArray = timeColumn.stream().mapToInt(Integer::intValue).toArray();
	        String[] communicationkindArray = communicationKindColumn.toArray(new String[0]);
	        
	        // Execução do Insertion Sort e impressão do tempo de execução
	        System.out.println("Ordenação usando Insertion Sort:");
	        double insertionSortTimed = InsertionSort.sort(dataArray);
	        System.out.println("Tempo de execução da ordenação InsertionSort(data): " + insertionSortTimed + " segundos");
	        
	        double insertionSortTimet = InsertionSort.sort(timeArray);
	        System.out.println("Tempo de execução da ordenação InsertionSort(time): " + insertionSortTimet + " segundos");
	        
	        double insertionSortTimec = InsertionSort.sort(communicationkindArray);
	        System.out.println("Tempo de execução da ordenação InsertionSort(communication_kind): " + insertionSortTimec + " segundos");

	        // Salvando os dados ordenados pelo Insertion Sort em um novo arquivo Excel
	        List<Integer> sortedData = Arrays.asList(Arrays.stream(dataArray).boxed().toArray(Integer[]::new));
	        writeColumnToExcel(outputInsertionSortFile1, sortedData, 1);
	        System.out.println("Dados ordenados pelo InsertionSort(data) salvos em " + outputInsertionSortFile1);
	        
	        List<Integer> sortedTime = Arrays.asList(Arrays.stream(timeArray).boxed().toArray(Integer[]::new));
	        writeColumnToExcel(outputInsertionSortFile2, sortedTime, 2);
	        System.out.println("Dados ordenados pelo InsertionSort(time) salvos em " + outputInsertionSortFile2);
	        
	        List<Integer> sortedCommunicationkind = Arrays.stream(communicationkindArray)
	                .map(Integer::valueOf) // Convertendo cada String em Integer
	                .collect(Collectors.toList());
	        writeColumnToExcel(outputInsertionSortFile3, sortedCommunicationkind, 0);
	        System.out.println("Dados ordenados pelo InsertionSort(communication_kind) salvos em " + outputInsertionSortFile3);

	     // Re-leitura da coluna para realizar as outras ordenações
	        dataColumn = readDateColumnFromExcel(inputFile, 1);
	        dataArray = dataColumn.stream().mapToInt(date -> (int) date.getTime()).toArray();
	        
	        timeColumn = readColumnFromExcel(inputFile, 2, ExcelColumnType.INTEGER);
	        timeArray = timeColumn.stream().mapToInt(Integer::intValue).toArray();
	        
	        communicationKindColumn = readColumnFromExcel(inputFile, 0, ExcelColumnType.STRING);
	        communicationkindArray = communicationKindColumn.toArray(new String[0]);

	     // Execução do Selection Sort e impressão do tempo de execução
	        System.out.println("\nOrdenação usando Selection Sort:");
	        double selectionSortTimed = SelectionSort.sort(dataArray);
	        System.out.println("Tempo de execução da ordenação SelectionSort(data): " + selectionSortTimed + " segundos");
	        
	        double selectionSortTimet = SelectionSort.sort(timeArray);
	        System.out.println("Tempo de execução da ordenação SelectionSort(time): " + selectionSortTimet + " segundos");
	        
	        double selectionSortTimec = SelectionSort.sort(communicationkindArray);
	        System.out.println("Tempo de execução da ordenação SelectionSort(communication_kind): " + selectionSortTimec + " segundos");

	        // Execução do Merge Sort e impressão do tempo de execução
	        System.out.println("\nOrdenação usando Merge Sort:");
	        double mergeSortTimed = MergeSort.sort(dataArray);
	        System.out.println("Tempo de execução da ordenação MergeSort(data): " + mergeSortTimed + " segundos");
	        
	        double mergeSortTimet = MergeSort.sort(timeArray);
	        System.out.println("Tempo de execução da ordenação MergeSort(time): " + mergeSortTimet + " segundos");
	        
	        double mergeSortTimec = MergeSort.sort(communicationkindArray);
	        System.out.println("Tempo de execução da ordenação MergeSort(communication_kind): " + mergeSortTimec + " segundos");


	        // Execução do Quick Sort e impressão do tempo de execução
	        System.out.println("\nOrdenação usando Quick Sort:");
	        double quickSortTimed = QuickSort.sort(dataArray);
	        System.out.println("Tempo de execução da ordenação QuickSort(data): " + quickSortTimed + " segundos");
	        
	        double quickSortTimet = QuickSort.sort(timeArray);
	        System.out.println("Tempo de execução da ordenação Quick Sort(time): " + quickSortTimet + " segundos");
	        

	        // Execução do Quick Sort com Mediana de 3 e impressão do tempo de execução
	        System.out.println("\nOrdenação usando Quick Sort com Mediana de 3:");
	        double quickSortMedianOfThreeTimed = QuickSortMedianOfThree.sort(dataArray);
	        System.out.println("Tempo de execução da ordenação QuickSort com Mediana de 3(data): " + quickSortMedianOfThreeTimed + " segundos");
	        
	        double quickSortMedianOfThreeTimet = QuickSortMedianOfThree.sort(timeArray);
	        System.out.println("Tempo de execução da ordenação QuickSort com mediana de 3(time): " + quickSortMedianOfThreeTimet + " segundos");
	        
	        
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

