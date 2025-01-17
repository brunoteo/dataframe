[//]: # (title: parse)
<!---IMPORT org.jetbrains.kotlinx.dataframe.samples.api.Modify-->

Returns [`DataFrame`](DataFrame.md) in which given `String` columns are parsed into other types.

Special case of [convert](convert.md) operation.

<!---FUN parseAll-->

```kotlin
df.parse()
```

<dataFrame src="org.jetbrains.kotlinx.dataframe.samples.api.Modify.parseAll.html"/>
<!---END-->

To parse only particular columns use [column selector](ColumnSelectors.md):

<!---FUN parseSome-->

```kotlin
df.parse { age and weight }
```

<dataFrame src="org.jetbrains.kotlinx.dataframe.samples.api.Modify.parseSome.html"/>
<!---END-->

`parse` tries to parse every`String` column into one of supported types in the following order:
* `Int`
* `Long`
* `LocalDateTime`
* `LocalDate`
* `LocalTime`
* `URL`
* `Double`
* `Boolean`
* `BigDecimal`

Available parser options:
* `locale: Locale` is used to parse numbers
* `dateTimePattern: String` is used to parse date and time
* `dateTimeFormatter: DateTimeFormatter` is used to parse date and time
* `nullStrings: List<String>` is used to treat particular strings as `null` value. Default null strings are **"null"** and **"NULL"**

<!---FUN parseWithOptions-->

```kotlin
df.parse(options = ParserOptions(locale = Locale.CHINA, dateTimeFormatter = DateTimeFormatter.ISO_WEEK_DATE))
```

<dataFrame src="org.jetbrains.kotlinx.dataframe.samples.api.Modify.parseWithOptions.html"/>
<!---END-->

You can also set global parser options that will be used by default in [`read`](read.md), [`convert`](convert.md) and `parse` operations:

<!---FUN globalParserOptions-->

```kotlin
DataFrame.parser.locale = Locale.FRANCE
DataFrame.parser.addDateTimePattern("dd.MM.uuuu HH:mm:ss")
```

<!---END-->
