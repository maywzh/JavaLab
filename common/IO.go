package main

import "fmt"

func main() {
	var m, n int
	var x, y int
	fmt.Scanln(&m, &n)
	fmt.Scanln(&x, &y)
	// var hash [][]int = make([][]int, m)
	// for i := 0; i < m; i++ {
	// 	hash[i] = make([]int, n)
	// 	for j := 0; j < n; j++ {
	// 		fmt.Scan(&hash[i][j])
	// 	}
	// }
	fmt.Println(m, n, x, y)
	// fmt.Println(hash)
}
