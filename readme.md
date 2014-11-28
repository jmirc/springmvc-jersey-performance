

# Command line
```
ab -n10000 -c50 -k http://localhost:8080/
```
The same entity is returned

## JERSEY  - Undertow

Title|1st round|2nd round|3rd round
-----------------------------|-----------------------------|-----------------------------
Document Length|4230 bytes|4320 bytes|4320 bytes
Concurrency Level|50|50|50
Time taken for tests|5.456 seconds|28.515 seconds|4.878 seconds
Complete requests|10000|10000|10000
Total transferred|43510000|43510000|43510000
HTML transferred|42300000|42300000|42300000
Requests per second|1824.59 (mean)|352.70 (mean)|2049.98 (mean)
Time per request (mean)|142.574 ms| 4.833 ms|24.390 ms
Time per request (mean, across all concurrent requests)|0.548 ms|2.851 ms|0.488 ms
Transfer rate|7752.72 Kbytes/sec|1490.11 Kbytes/sec|8711.28 Kbytes/sec
Connection Times (ms)|min  mean[+/-sd] median   max|min  mean[+/-sd] median   max|min  mean[+/-sd] median   max
Connect|0   8  6.7      7     33| 0    118   1068.9      15       13480|0    6   5.6      5       50
Processing|4   19  5.8     18     45|1    24   8.7      24      108|3    18   5.1      17       63
Waiting|4   15  4.2      16     40| 1    18   7      18      107|3    15   4.1      15       58
Total|4   27  9.9     25     68|2    142   1068.2      39      13513|4    24   8.1      22       66
Percentage of the requests served within a certain time (ms)|||
  50% |25|39|22
  66% |30|42|26
  75% |33|45|29
  80% |36|47|30
  90% |42|52|35
  95% |46|56|39
  98% |51|66|45
  99% |54|7085|68
 100%| 68|13513|66
