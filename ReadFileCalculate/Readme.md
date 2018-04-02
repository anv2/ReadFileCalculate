README
## Read file and Calculate


Contents</br>
Introduction</br>
Documentation</br>

### Introduction</br>
This application could be used to process any csv file with a format comprising of four columns of data types String, String, Integer, and String. The fields for these data types are Name, Date of birth, Annual Salary, and Role. </br>
Specifically, this application takes the input file and calculation type as arguments using the command line. After parsing the file, it finds the following:</br>
a. Total salary in dollars. </br>
b. Total salary in dollars grouped by role. </br>
c. Total salary in dollars by time unit (hour, week, month). </br>
d. Total salary in dollars by time unit grouped by role. </br>
e. Grouping of people whose annual salary are as close to the input salary limit L without going over L. Hence, the parameter is salary limit L. The output is a group of employees.</br>
The output is printed to terminal.</br>

### Documentation</br>

File is chosen by typing into terminal the path of the file. The application comes with one starter csv file named "records.csv" that could be tested with. If you have a file you'd like to use, add the file to your package containing the provided code (outside of src folder), and the name of the file would likely be filename.csv.
</br>

![alt text](https://github.com/anv2/ReadFileCalculate/blob/master/ReadFileCalculate/ImagesReadFileCalculate/path.png =50x)
</br>
After choosing a csv file to compute, the user is prompted to enter a number from 0 to 4, which corresponds to computation options from a to e mentioned in the above paragraph. </br>
