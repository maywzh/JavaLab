/*
 *  fork_test.c
 *  version 1
 *  Created on: 2010-5-29
 *      Author: maywzh
 */
#include <unistd.h>
#include <stdio.h>
int main()
{
    pid_t fpid; //fpid表示fork函数返回的值
    int count = 0;
    fpid = fork();
    if (fpid < 0)
        printf("error in fork!");
    else if (fpid == 0)
    {
        printf("i am the child process, my process id is %d\n", getpid());
        count++;
    }
    else
    {
        printf("i am the parent process, my process id is %d\n", getpid());
        count++;
    }
    printf("The result: %d\n", count);
    return 0;
}