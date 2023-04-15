1. Password was cracked by thread 3

2. The three threads cooporate with the parent process to share memory. When each thread uses memory from the parent process, 
they are sharing memory based on whether the password is found or not. This is important as it would need to be shared with the all 3 threads 
in order to set the found field as true.

3. The average time it took for the multi-threaded process to find the password is around 90-100ms. According to the program, 
it took 152639 iterations for the multi-threaded process. If we wanted to compare the single-threaded process, we could calculate it 
to roughly 26^4 = 456976. It would be to the power of 4, as the program we already start with an inital char. This means that the 
multi-threaded process is about 3x faster than the single-threaded process.

4. Assuming the order of process is the middle (i, v, t), multi-threaded would still be faster. The only time the times would be the 
same, is if v was first in the order for single-threaded process. This would mean that the program would automatically start with a correct 
first letter. If we take into account the order of i, v, t, the multi-threaded process would be about 2x faster, or 2x slower 
on the single-threaded end. 