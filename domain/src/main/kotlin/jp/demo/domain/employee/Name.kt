package jp.demo.employee

data class Name(val firstName: String , val lastName: String) {
    constructor(fullName: String): this(fullName.split(" ","　")[1], fullName.split(" ","　")[0])
}