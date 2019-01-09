import java.util.*;
import java.io.*;
/**
 * 'MarkProcessor' handles all the data that essentially makes up a 'StudentRecord'
 * object.
 *
 * This class reads the details of students such as their name and the marks 
 * they were allocated and stores that input in a 'StudentRecord' object which is then 
 * added to an <code>ArrayList</code>.
 *
 * @author Zac King
 * @version 08/02/2018
 */
public class MarkProcessor
{
    //Name of the cohort of students
    private String nameOfCohort;
    //Used to store each student's record
    private ArrayList<StudentRecord> marksList;

    /**
     * Constructor for objects of class MarkProcessor
     */
    public MarkProcessor()
    {
        // initialise instance variables
        marksList = new ArrayList<StudentRecord>();
    }

    /**
     * This method returns the name of the student cohort.
     * 
     * @return the name of the student cohort.
     */
    public String getNameOfCohort()
    {
        return nameOfCohort;
    }
    
    /**
     * This method returns the name of the student cohort.
     * 
     * @param newName this is the name we want to assign as the new name of cohort.
     */
    public void setNameOfCohort(String newNameOfCohort)
    {
        nameOfCohort = newNameOfCohort;
    }

    /**
     * This method stores a student record in the 'markList' <code>ArrayList</code>.
     * The private access modifier is used because we are only using this within the same class and it doesn't
     * need to be used externally or by the user themselves.
     * 
     * @param newRecord the record we want to store in 'marksList'.
     */
    private void storeStudentRecord(StudentRecord newRecord)
    {
        marksList.add(newRecord);
    }

    /**
     * This method prints the results that were read in from a file to the terminal
     * window. 
     * 
     */
    public void displayResults()
    {
        System.out.println("Results for " + nameOfCohort);
        System.out.print("\tName");
        System.out.print("\t\t\t\t\tMarks");
        System.out.println("\t\t\t\tAverage");
        int counter = 1;            //this counter is for the number to the left of each student.
        for(StudentRecord student: marksList)
        {
            int markArray[] = student.getMarks();
            int sum = 0;
            System.out.print(counter + "\t" + student.getName() + "\t\t\t\t");
            for(int i = 0; i < markArray.length; i++)
            {
                
                System.out.print(markArray[i] + " ");
                sum += markArray[i];
                
            }
            
            int markAverage = sum / student.getNoOfMarks();
            System.out.print("\t\t\t\t" + markAverage);
            
            System.out.println();

            counter++;
        }

    }

    /**
     * This method reads data from a specified data file using the <code>Scanner</code> object and 
     * stores the marks of each student in an array.
     * 
     * @param fileName The name of the file we want to read from.
     * @throws FileNotFoundException If an I/O error occurs.
     * 
     */
    public void readMarksData(String fileName) throws FileNotFoundException
    {
        File dataFile = new File(fileName);
        Scanner scanner = new Scanner(dataFile);

        setNameOfCohort(scanner.nextLine());
        int numberOfMarks = scanner.nextInt();
        scanner.nextLine();             //advance to the next line.

        while( scanner.hasNext() )
        {
            int marks[] = new int[numberOfMarks];
            String studentName = scanner.nextLine();

            int counter = 0;
            while( scanner.hasNextInt())
            {
                marks[counter] = scanner.nextInt();
                counter++; 
            }

            storeStudentRecord(new StudentRecord(studentName, marks));
            //System.out.println("Name: " + studentName + " Marks: ");

            scanner.nextLine();

        }

        scanner.close();
    }
    
    /**
     * This method uses the same format as reading the data to write all student's records to a 
     * text file.
     * 
     * @param fileName this allows us to set the name of the text file we want to write the student 
     * data to.
     * @throws FileNotFoundException If an I/O error occurs.
     */
    public void writeMarksData(String fileName) throws FileNotFoundException
    {
        PrintWriter pWriter = new PrintWriter(fileName);
        pWriter.println(nameOfCohort);

        for(StudentRecord student : marksList)
        {
            int[] marks = student.getMarks();

            String lineOfOutput = "Name: " + student.getName() + " Marks: ";

            pWriter.print(lineOfOutput);    //Notice the use of '.print()' to stay on the current line so we can
                                            //process the marks as well (shown below).

            for(int i = 0; i < marks.length; i++)
            {
                pWriter.print(marks[i] + " "); 
            }

            pWriter.println();
        }

        pWriter.close();
    }

    /**
     * This method iterates over and removes all entries from marksList, which is convenient 
     * when wanting to display other student results.
     * 
     */
    public void clearMarksData()
    {
        Iterator<StudentRecord> studentIt = marksList.iterator();

        while(studentIt.hasNext())
        {
            StudentRecord student = studentIt.next();
            studentIt.remove();
        }
    }
    
    /**
     * This method iterates over and removes all entries from marksList, which is convenient 
     * when wanting to display other student results.
     * 
     * @param studentPosn the position of the student in 'marksList'.
     * @param markPosn the position of the mark in 'marks'.
     * @param newMark the new mark we want to assign to the mark at the specified position.
     * 
     */
    public void editMarksData(int studentPosn, int markPosn, int newMark)
    {
        StudentRecord student = marksList.get(studentPosn - 1);     //-1 for the reason of zero-based indexing
        int[] marks = student.getMarks();
        marks[markPosn - 1] = newMark;
    }
}
