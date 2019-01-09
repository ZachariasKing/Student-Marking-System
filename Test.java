import java.io.*;   //Used to import the 'FileNotFoundException' so we can throw it.
/**
 * 'Test' models a representation of how the user would go through the system step-by-step.
 *
 * @author Zacharias
 * @version 08/02/2018
 */
public class Test
{
    // No instance variables needed as this is simply a test class.
    /**
     * Constructor for objects of class TestThis constructor, providing comments for each unit, will test
     * the fundamental processes we need to carry out in order for this program to be successful. This will include any conditional 
     * statements, methods and objects being created.
     * 
     * @throws FileNotFoundException If an I\O error occurs.
     */
    public Test()  throws FileNotFoundException
    {
        //Step 1 and Step 2, (Setting up classes 'StudentRecord' and 'MarkProcessor' and reading data from files and compute
        //average of each students marks) an instance of 'MarkProcessor' is first created because this will read in from the 
        //file given and then create multiple anonymous 'Student Record' objects which are stored in the 'marksList' ArrayList.
        
        MarkProcessor marksProcess = new MarkProcessor();
        
        marksProcess.readMarksData("data1.txt");    //'readMarksData()' invokes the private 'storeStudentRecord()' inside of it.
        marksProcess.displayResults();              
        
        marksProcess.readMarksData("data2.txt");
        marksProcess.displayResults();             //this method is part of step 2 with it now computing averages of student's marks.
        
        //Step 3, (More Methods of the 'MarkProcessor class), we can now test more method of the 'MarkProcessor' class allowing us to 
        //write student data to a text file using 'writeMarksData()', remove all data from marksList using 'clearMarksData()' and 
        //also edit the data using 'editMarksData()'.
        
        marksProcess.writeMarksData("newDataFile.txt");      //in this case, we will be writing the contents
                                                            //of both 'data1.txt' and 'data2.txt' to a file.
                                                           
        
        marksProcess.clearMarksData();              //this is done to read the contents of our new file
                                                    //in order to check both the removal and writing of data worked successfully.
                                                    
        marksProcess.readMarksData("newDataFile.txt");
        marksProcess.displayResults();  
        
        marksProcess.editMarksData(1, 1, 99);       //this should find student listed first, and swap their first mark for 99.
        marksProcess.displayResults();
        
    }

}
