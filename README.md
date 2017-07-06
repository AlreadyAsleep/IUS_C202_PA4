# IUS_C202_PA4
Programming Assignment 4 from Dr. H's 202 class
<hr>
<h3>Abtstract</h3>
This problem is essentially to design a basic spell check program for a text file using an array of singly linked lists data structure. Essentially, each list contains strings that all begin with a certain character. When the program reaches a word in the file, it queries the list that begins with the same letter as that word, checking to see if the word exists in the "dictionary’ made up of lists of alphabetized words. The program also checks to see how many times it compares words in the file to words in the dictionary. It returns the average comparisons made to find any given word. 

The efficiency of the algorithm for this program could definitely be improved. The space complexity is not terrible as only N node objects are being created that only contain strings and a reference. However, the time complexity of this algorithm is clearly O(NK), with K being the number of words in the dictionary that begin with the queried character, and N being the number of words in the file. Using a strictly linear data structure will cause this inherently, however if a tree like structure was used that could be more easily traversed, the time complexity would improve dramatically. In the case of this particular test case, after ten executions the program took 1’45’’ to execute completely. 
<h3>Outputs</h3>

Words found: 796518

Words not found: 173165 

Comparisons made that found a match: 2530198496

Comparisons made with no match: 1295691228

Average comparisons per word found: 3176 

Average comparisons per word not found: 7482

BUILD SUCCESSFUL (total time: 1 minute 36 seconds) 
