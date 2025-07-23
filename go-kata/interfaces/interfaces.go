package interfaces

// List interface for all list implementations
type List[T any] interface {
	Length() int
	RemoveAt(index int) *T
	Remove(item T) *T
	Get(index int) *T
	Prepend(item T)
	Append(item T)
	InsertAt(item T, idx int)
}