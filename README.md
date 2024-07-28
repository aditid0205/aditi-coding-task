This project analyzes a log file containing web server access logs. It retrieves below information 
- unique IP addresses
- top visited URLs
- top visitor IPs
  
Location of the log file:
 - src\main\resources\programming-task-example-data.log
 - By modifying the file_path in ApplicationConstant.java, any other log file can be analyzed 

Output:
The program will print the following information to the console:
- Unique IPs: This shows the total number of distinct IP addresses found in the log file.
- Top 3 Urls: This displays the three URLs with the highest number of accesses.
- Top 3 IPs: This shows the three IP addresses that made the most requests to the server.
