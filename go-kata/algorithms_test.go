package main

import (
	"fmt"
	"os"
	"path/filepath"
	"sort"
	"strconv"
	"strings"
	"testing"

	"github.com/stretchr/testify/assert"
)

func getCurrentDay() (string, error) {
	entries, err := os.ReadDir(".")
	if err != nil {
		return "day1", err
	}

	var dayNumbers []int
	for _, entry := range entries {
		if entry.IsDir() && strings.HasPrefix(entry.Name(), "day") {
			numStr := strings.TrimPrefix(entry.Name(), "day")
			if num, err := strconv.Atoi(numStr); err == nil {
				dayNumbers = append(dayNumbers, num)
			}
		}
	}

	if len(dayNumbers) == 0 {
		return "day1", nil
	}

	sort.Ints(dayNumbers)
	return fmt.Sprintf("day%d", dayNumbers[len(dayNumbers)-1]), nil
}

func TestLinearSearch(t *testing.T) {
	currentDay, err := getCurrentDay()
	assert.NoError(t, err)

	// Test file should exist
	testFile := filepath.Join(currentDay, "LinearSearchList.go")
	_, err = os.Stat(testFile)
	assert.NoError(t, err, "LinearSearchList.go should exist")
}

func TestBinarySearch(t *testing.T) {
	currentDay, err := getCurrentDay()
	assert.NoError(t, err)

	// Test file should exist
	testFile := filepath.Join(currentDay, "BinarySearchList.go")
	_, err = os.Stat(testFile)
	assert.NoError(t, err, "BinarySearchList.go should exist")
}

func TestTwoCrystalBalls(t *testing.T) {
	currentDay, err := getCurrentDay()
	assert.NoError(t, err)

	// Test file should exist
	testFile := filepath.Join(currentDay, "TwoCrystalBalls.go")
	_, err = os.Stat(testFile)
	assert.NoError(t, err, "TwoCrystalBalls.go should exist")
}

func TestBubbleSort(t *testing.T) {
	currentDay, err := getCurrentDay()
	assert.NoError(t, err)

	// Test file should exist
	testFile := filepath.Join(currentDay, "BubbleSort.go")
	_, err = os.Stat(testFile)
	assert.NoError(t, err, "BubbleSort.go should exist")
}

func TestQueue(t *testing.T) {
	currentDay, err := getCurrentDay()
	assert.NoError(t, err)

	// Test file should exist
	testFile := filepath.Join(currentDay, "Queue.go")
	_, err = os.Stat(testFile)
	assert.NoError(t, err, "Queue.go should exist")
}

func TestStack(t *testing.T) {
	currentDay, err := getCurrentDay()
	assert.NoError(t, err)

	// Test file should exist
	testFile := filepath.Join(currentDay, "Stack.go")
	_, err = os.Stat(testFile)
	assert.NoError(t, err, "Stack.go should exist")
}

func TestArrayList(t *testing.T) {
	currentDay, err := getCurrentDay()
	assert.NoError(t, err)

	// Test file should exist
	testFile := filepath.Join(currentDay, "ArrayList.go")
	_, err = os.Stat(testFile)
	assert.NoError(t, err, "ArrayList.go should exist")
}

func TestSinglyLinkedList(t *testing.T) {
	currentDay, err := getCurrentDay()
	assert.NoError(t, err)

	// Test file should exist
	testFile := filepath.Join(currentDay, "SinglyLinkedList.go")
	_, err = os.Stat(testFile)
	assert.NoError(t, err, "SinglyLinkedList.go should exist")
}

func TestDoublyLinkedList(t *testing.T) {
	currentDay, err := getCurrentDay()
	assert.NoError(t, err)

	// Test file should exist
	testFile := filepath.Join(currentDay, "DoublyLinkedList.go")
	_, err = os.Stat(testFile)
	assert.NoError(t, err, "DoublyLinkedList.go should exist")
}