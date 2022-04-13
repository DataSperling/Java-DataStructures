## Why Data Structures?

Data storage and retrieval are important for managing large amounts of data efficiently. Inefficient coding practices (e.g. repeatedly looping over the data with a for loop) can lead to excessively slow applications as well as an exaggerated memory footprint of an application. This is especially true in mobile development where the average RAM of a users mobile is 4GB.

### Comparing Efficiency of Data Structures

Big-O notation is commonly used to compare the limiting behaviour of computational processes such as adding or removing data from a data structure like an array or searching for a repeating pattern in a string or series of numbers. It is used to explain the time or space complexity change of algorithmic processes as a function of input size, often in an asymptotically limited context. 

### Arrays: A Simple Example

An array is stored in contiguous memory and the size is specified at instantiation. This leads to two important consequences; firstly we can always access a known element in constant time, that is a time scale independent of the size of the data set and secondly that when the array is full a new array must be instantiated and the old data copied over. This process is extremely inefficient and needs to be avoided or minimised where possible.

### Adding to an Array

Adding to the end of an array is asymptotic O(1) or O(1)*, inserting in the middle is O(n) as the following elements need to be moved.
