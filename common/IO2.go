package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func main() {
	input := bufio.NewScanner(os.Stdin)
	for input.Scan() {
		a := strings.Split(input.Text(), ",")
		a0, _ := strconv.Atoi(a[0])
		a1, _ := strconv.Atoi(a[1])
		fmt.Println(a0 + a1)
	}
	fmt.Sprintf("%.2f", 3.456465)
}
