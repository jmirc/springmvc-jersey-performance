# Use same entity

## Spring MVC  - Undertow

Command line

```
ab -n10000 -c50 -k http://localhost:8080/
```
### Best result after 3 rounds

```
Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /
Document Length:        4325 bytes

Concurrency Level:      50
Time taken for tests:   3.106 seconds
Complete requests:      10000
Failed requests:        0
Write errors:           0
Keep-Alive requests:    0
Total transferred:      44468892 bytes
HTML transferred:       43258650 bytes
Requests per second:    3219.68 [#/sec] (mean)
Time per request:       15.529 [ms] (mean)
Time per request:       0.311 [ms] (mean, across all concurrent requests)
Transfer rate:          13982.00 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    7   4.7      7      61
Processing:     1    8   4.1      7      61
Waiting:        1    8   4.2      7      61
Total:          3   15   7.3     14      71

Percentage of the requests served within a certain time (ms)
  50%     14
  66%     17
  75%     19
  80%     20
  90%     24
  95%     26
  98%     29
  99%     41
 100%     71 (longest request)
```

 
