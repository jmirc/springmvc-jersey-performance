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

### Worst response time after 3 rounds

```
Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /
Document Length:        4325 bytes

Concurrency Level:      50
Time taken for tests:   27.464 seconds
Complete requests:      10000
Failed requests:        0
Write errors:           0
Keep-Alive requests:    0
Total transferred:      44460000 bytes
HTML transferred:       43250000 bytes
Requests per second:    364.11 [#/sec] (mean)
Time per request:       137.322 [ms] (mean)
Time per request:       2.746 [ms] (mean, across all concurrent requests)
Transfer rate:          1580.88 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0  122 1508.3     14   21431
Processing:     1   15   7.5     14     113
Waiting:        0   15   7.3     14     113
Total:          1  137 1507.8     29   21447

Percentage of the requests served within a certain time (ms)
  50%     29
  66%     32
  75%     35
  80%     38
  90%     41
  95%     44
  98%     53
  99%    127
 100%  21447 (longest request)
```

## Jersey

Command line

```
ab -n10000 -c50 -k http://localhost:8080/jersey
```
### Best reponse time after 3 rounds

```
Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /jersey
Document Length:        4325 bytes

Concurrency Level:      50
Time taken for tests:   0.651 seconds
Complete requests:      10000
Failed requests:        0
Write errors:           0
Keep-Alive requests:    10000
Total transferred:      44823933 bytes
HTML transferred:       43340825 bytes
Requests per second:    15367.07 [#/sec] (mean)
Time per request:       3.254 [ms] (mean)
Time per request:       0.065 [ms] (mean, across all concurrent requests)
Transfer rate:          67266.86 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       1
Processing:     1    3   1.1      3      15
Waiting:        0    3   1.1      3      15
Total:          1    3   1.1      3      15

Percentage of the requests served within a certain time (ms)
  50%      3
  66%      3
  75%      4
  80%      4
  90%      4
  95%      5
  98%      7
  99%      7
 100%     15 (longest request)
```

### Worst response time after 3 rounds

```
Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /jersey
Document Length:        4325 bytes

Concurrency Level:      50
Time taken for tests:   0.750 seconds
Complete requests:      10000
Failed requests:        0
Write errors:           0
Keep-Alive requests:    10000
Total transferred:      44823933 bytes
HTML transferred:       43340825 bytes
Requests per second:    13331.70 [#/sec] (mean)
Time per request:       3.750 [ms] (mean)
Time per request:       0.075 [ms] (mean, across all concurrent requests)
Transfer rate:          58357.34 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       1
Processing:     1    4   2.5      3      68
Waiting:        0    4   2.5      3      68
Total:          1    4   2.5      3      68

Percentage of the requests served within a certain time (ms)
  50%      3
  66%      4
  75%      4
  80%      4
  90%      5
  95%      6
  98%      8
  99%      9
 100%     68 (longest request)
```
 
# Get a randomly entity

## Spring MVC  - Undertow

Command line

```
ab -n10000 -c50 -k http://localhost:8080/random
```
### Best response time after 3 rounds

```
Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /random
Document Length:        4314 bytes

Concurrency Level:      50
Time taken for tests:   3.622 seconds
Complete requests:      10000
Failed requests:        9801
   (Connect: 0, Receive: 0, Length: 9801, Exceptions: 0)
Write errors:           0
Keep-Alive requests:    0
Total transferred:      42155990 bytes
HTML transferred:       40945627 bytes
Requests per second:    2761.16 [#/sec] (mean)
Time per request:       18.108 [ms] (mean)
Time per request:       0.362 [ms] (mean, across all concurrent requests)
Transfer rate:          11367.14 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    8   5.5      7      67
Processing:     3   10   4.4      9      67
Waiting:        1    9   4.3      8      67
Total:          4   18   7.9     17      82

Percentage of the requests served within a certain time (ms)
  50%     17
  66%     20
  75%     22
  80%     23
  90%     26
  95%     29
  98%     34
  99%     49
 100%     82 (longest request)
```
### Worst reponse time after 3 rounds

Got a timeout request 

```
Benchmarking localhost (be patient)
Completed 1000 requests
Completed 2000 requests
Completed 3000 requests
Completed 4000 requests
Completed 5000 requests
Completed 6000 requests
apr_socket_recv: Operation timed out (60)
Total of 6390 requests completed
```

## Jersey

Command line

```
ab -n10000 -c50 -k http://localhost:8080/jersey/random
```
### Best response time after 3 rounds

```
Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /jersey/random
Document Length:        2118 bytes

Concurrency Level:      50
Time taken for tests:   0.654 seconds
Complete requests:      10000
Failed requests:        9816
   (Connect: 0, Receive: 0, Length: 9816, Exceptions: 0)
Write errors:           0
Keep-Alive requests:    10000
Total transferred:      42553440 bytes
HTML transferred:       41072256 bytes
Requests per second:    15296.27 [#/sec] (mean)
Time per request:       3.269 [ms] (mean)
Time per request:       0.065 [ms] (mean, across all concurrent requests)
Transfer rate:          63565.34 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       2
Processing:     1    3   1.2      3      11
Waiting:        0    3   1.2      3      11
Total:          1    3   1.2      3      11

Percentage of the requests served within a certain time (ms)
  50%      3
  66%      3
  75%      4
  80%      4
  90%      4
  95%      5
  98%      6
  99%      8
 100%     11 (longest request)
```

### Worst response time after 3 rounds

```
Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /jersey/random
Document Length:        2313 bytes

Concurrency Level:      50
Time taken for tests:   0.662 seconds
Complete requests:      10000
Failed requests:        9810
   (Connect: 0, Receive: 0, Length: 9810, Exceptions: 0)
Write errors:           0
Keep-Alive requests:    10000
Total transferred:      42591373 bytes
HTML transferred:       41110633 bytes
Requests per second:    15097.69 [#/sec] (mean)
Time per request:       3.312 [ms] (mean)
Time per request:       0.066 [ms] (mean, across all concurrent requests)
Transfer rate:          62796.03 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    0   0.1      0       1
Processing:     1    3   1.3      3      20
Waiting:        0    3   1.3      3      20
Total:          1    3   1.3      3      20

Percentage of the requests served within a certain time (ms)
  50%      3
  66%      3
  75%      3
  80%      4
  90%      4
  95%      5
  98%      7
  99%      8
 100%     20 (longest request)
```

  
  
