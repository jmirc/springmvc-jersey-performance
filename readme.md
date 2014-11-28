# Use same entity

## Spring MVC  - Undertow

Command line

```
ab -n10000 -c50 -k http://localhost:8080/
```


Title|1st round|2nd round|3rd round
-----------------------------|-----------------------------|-----------------------------|-----------------------------
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
 
## JERSEY  - Undertow

Command line

```
ab -n10000 -c50 -k http://localhost:8080/jersey/
```


Title|1st round|2nd round|3rd round
-----------------------------|-----------------------------|-----------------------------|-----------------------------
Document Length|4230 bytes|4320 bytes|4320 bytes
Concurrency Level|50|50|50
Time taken for tests|3.278 seconds|3.267 seconds|3.320 seconds
Complete requests|10000|10000|10000
Total transferred|43780000|43780000|43780000
HTML transferred|42300000|42300000|42300000
Requests per second|3050.98 (mean)|3060.52 (mean)|3011.96 (mean)
Time per request (mean)|16.388 ms| 16.337 ms|16.600 ms
Time per request (mean, across all concurrent requests)|0.328 ms|0.327 ms|0.332 ms
Transfer rate|16.388 Kbytes/sec|13084.92 Kbytes/sec|12879.89 Kbytes/sec
Connection Times (ms)|min  mean[+/-sd] median   max|min  mean[+/-sd] median   max|min  mean[+/-sd] median   max
Connect|0   0  0.1      0     1| 0   0  0.1      0     1|0   0  0.1      0     1
Processing|6   16  1.6     16     35|6   16  1.6     16     29|7   17  1.6     16     30
Waiting|6   16  1.5      16     35|6   16  1.6     16     29|7   17  1.6      16     30
Total|6   16  1.5     16     35|6   16  1.6      16     29|8   17  1.6      16     31
Percentage of the requests served within a certain time (ms)|||
  50% |16|16|16
  66% |16|17|17
  75% |17|17|17
  80% |17|17|17
  90% |18|18|19
  95% |19|19|19
  98% |21|21|21
  99% |21|22|22
 100%| 35|29|31
 
 
# Return different entity each call

## Spring MVC  - Undertow

Command line

```
ab -n10000 -c50 -k http://localhost:8080/random
```


Title|1st round|2nd round|3rd round
-----------------------------|-----------------------------|-----------------------------|-----------------------------
Document Length|4437 bytes|4320 bytes|4320 bytes
Concurrency Level|50|50|50
Time taken for tests|23.727 seconds|21.057 seconds|4.878 seconds
Complete requests|10000|10000|10000
Total transferred|42526815|42275961|42168845
HTML transferred|41314637|41063783|40956425
Requests per second|421.45 (mean)|474.90 (mean)|2049.98 (mean)
Time per request (mean)|118.637 ms| 105.286 ms|419.23 ms
Time per request (mean, across all concurrent requests)|2.373 ms|2.106 ms|2.385 ms
Transfer rate|1750.30 Kbytes/sec|1960.61 Kbytes/sec|1726.41 Kbytes/sec
Connection Times (ms)|min  mean[+/-sd] median   max|min  mean[+/-sd] median   max|min  mean[+/-sd] median   max
Connect|0   17  15.1      15     66|1    31   23.1      29       365|0    53   349.1      26       5036
Processing|12   101  86.6     73     803|11    72   34.8      67      404|6    65   26.0      61       229
Waiting|9   88  90.2      52     776|8    52   28.9      47      368|5    47   21.1      44       204
Total|12   118  80.9     95     804|28    103   40.7      95      457|6    118   348.7      87       5095
Percentage of the requests served within a certain time (ms)|||
  50% |95|95|87
  66% |103|101|93
  75% |113|105|97
  80% |129|109|101
  90% |210|124|111
  95% |269|177|161
  98% |347|258|230
  99% |410|281|248
 100%|804|457|5095
 
## JERSEY  - Undertow

Command line

```
ab -n10000 -c50 -k http://localhost:8080/jersey/random
```


Title|1st round|2nd round|3rd round
-----------------------------|-----------------------------|-----------------------------|-----------------------------
Document Length|4441 bytes|4893 bytes|4949 bytes
Concurrency Level|50|50|50
Time taken for tests|13.851 seconds|13.652 seconds|13.701 seconds
Complete requests|10000|10000|10000
Total transferred|42533601|42466007|42507661
HTML transferred|41053601|40986007|41027661
Requests per second|721.96 (mean)|732.49 (mean)|729.90 (mean)
Time per request (mean)|69.256 ms|68.260 ms|68.503 ms
Time per request (mean, across all concurrent requests)|1.385 ms|1.365 ms|1.370 ms
Transfer rate|16.388 Kbytes/sec|3037.69 Kbytes/sec|3029.91 Kbytes/sec
Connection Times (ms)|min  mean[+/-sd] median   max|min  mean[+/-sd] median   max|min  mean[+/-sd] median   max
Connect|0   0  0.1      0     1| 0   0  0.1      0     2|0   0  0.1      0     1
Processing|7   69  96.7     19     744|8   68  91.9     19     814|8   68  96.2     19     889
Waiting|7   69  96.7      19     744|6   68  91.9     19     814|8   68  96.2      19    889
Total|7   69  96.7     19     744|6   68  91.9      19     814|8   68  96.2      19     889
Percentage of the requests served within a certain time (ms)|||
  50% |19|19|19
  66% |55|46|47
  75% |94|93|89
  80% |123|128|120
  90% |192|207|202
  95% |266|268|270
  98% |366|341|364
  99% |474|387|439
 100%| 744|814|889
 
 
