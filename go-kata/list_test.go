package main

import (
	"kata-machine/interfaces"
	"testing"

	"github.com/stretchr/testify/assert"
)

func testList(t *testing.T, list interfaces.List[int]) {
	list.Append(5)
	list.Append(7)
	list.Append(9)

	assert.Equal(t, 9, *list.Get(2))
	assert.Equal(t, 7, *list.RemoveAt(1))
	assert.Equal(t, 2, list.Length())

	list.Append(11)
	assert.Equal(t, 9, *list.RemoveAt(1))
	assert.Nil(t, list.Remove(9))
	assert.Equal(t, 5, *list.RemoveAt(0))
	assert.Equal(t, 11, *list.RemoveAt(0))
	assert.Equal(t, 0, list.Length())

	list.Prepend(5)
	list.Prepend(7)
	list.Prepend(9)

	assert.Equal(t, 5, *list.Get(2))
	assert.Equal(t, 9, *list.Get(0))
	assert.Equal(t, 9, *list.Remove(9))
	assert.Equal(t, 2, list.Length())
	assert.Equal(t, 7, *list.Get(0))
}