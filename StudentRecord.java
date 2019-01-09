/**
 * 'StudentRecord' models a record for a student in the sense that it
 * has a name, an amount of marks and the mark values themselves. 
 * 
 * 
 * @author Zacharias King
 * @version 08/02/2018
 */
public class StudentRecord
{
    //Name of the student
    private String name;
    //Number of marks per student
    private int noOfMarks;
    //Used to store the marks of each student
    private int[] marks;
    
    /**
     * Constructor for objects of class StudentRecord.
     * 
     * @param newName the name we give to the student.
     * @param newMarks the marks associated with that student (stored in an array).
     */
    public StudentRecord(String newName, int[] newMarks)
    {
        name = newName;
        marks = newMarks;
        noOfMarks = marks.length;
    }
    
    /**
     * This method returns the name of the student.
     * 
     * @return the name of the student.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * This method returns the number/amount of marks allocated to each student.
     * 
     * @return the number of marks given to each student.
     */
    public int getNoOfMarks()
    {
        return noOfMarks;
    }
    
    /**
     * This method returns the marks associated with one student instance.
     * 
     * @return the marks a student got in an <code>array</code> of int.
     */
    public int[] getMarks()
    {
        return marks;
    }
    
    /**
     * This method allows us to alter the name of the student via a mutator method.
     * 
     * @param newName is the new name we want to give the student.
     */
    public void setName(String newName)
    {
        name = newName;
    }

}
