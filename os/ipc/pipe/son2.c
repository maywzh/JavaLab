#include <stdio.h>
#include <unistd.h>
#include <string.h>
int main()
{
    int _pipe[2];
    int ret = pipe(_pipe);
    if (ret < 0)
    {
        perror("pipe\n");
    }
    pid_t id = fork();
    if (id < 0)
    {
        perror("fork\n");
    }
    else if (id == 0) // child
    {
        close(_pipe[0]);
        int i = 0;
        char *msg = NULL;
        while (i < 100)
        {
            msg = "I am child";
            write(_pipe[1], msg, strlen(msg) + 1);
            sleep(1);
            ++i;
        }
    }
    else //father
    {
        close(_pipe[1]);
        int j = 0;
        char _msg[100];
        while (j < 100)
        {
            memset(_msg, '\0', sizeof(_msg));
            read(_pipe[0], _msg, sizeof(_msg));
            printf("%s\n", _msg);
            j++;
        }
    }
    return 0;
}