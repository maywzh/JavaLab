package main

import "fmt"

func main() {
	var m, n int
	fmt.Scanln(&m, &n)
	var hash [][]int = make([][]int, m)
	for i := 0; i < m; i++ {
		hash[i] = make([]int, n)
		for j := 0; j < n; j++ {
			fmt.Scan(&hash[i][j])
		}
	}
	fmt.Println(hash)
}
