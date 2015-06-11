package model

abstract class Tag(val tag: String) {

}

// TODO: encode the structure in the same way that refs?

case class SimpleTag(override val tag: String) extends Tag(tag)

abstract class StructuredTag(override val tag: String) extends Tag(tag) {
  case class Root(override val tag: String) extends StructuredTag(tag)
  case class Node(override val tag: String, parent: StructuredTag) extends StructuredTag(tag)
}

// FIXME: name
case class TagWithRef[T <: Tag](t: T, r: Ref) extends Tag(t.tag)
