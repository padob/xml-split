## Scenario

We're getting a big XML file (> 30 GB) from a customer once per day.

Among other things, this file contains independent elements called `<SubjectData>` with plenty of content in them.
We want to extract all individual `<SubjectData>` elements into files of their own.

We expect none of these elements to contain more than about 50 MB worth of data.

## Task
Write a Java program that reads an XML file and does the splitting described above. Ideally with a unit test that doesn't write any files to the disk. 
