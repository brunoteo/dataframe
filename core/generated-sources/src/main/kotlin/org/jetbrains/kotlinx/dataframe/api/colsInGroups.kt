package org.jetbrains.kotlinx.dataframe.api

import org.jetbrains.kotlinx.dataframe.ColumnFilter
import org.jetbrains.kotlinx.dataframe.DataColumn
import org.jetbrains.kotlinx.dataframe.DataFrame
import org.jetbrains.kotlinx.dataframe.DataRow
import org.jetbrains.kotlinx.dataframe.columns.ColumnGroup
import org.jetbrains.kotlinx.dataframe.columns.ColumnPath
import org.jetbrains.kotlinx.dataframe.columns.ColumnSet
import org.jetbrains.kotlinx.dataframe.columns.ColumnWithPath
import org.jetbrains.kotlinx.dataframe.columns.SingleColumn
import org.jetbrains.kotlinx.dataframe.documentation.Indent
import org.jetbrains.kotlinx.dataframe.documentation.LineBreak
import org.jetbrains.kotlinx.dataframe.documentation.UsageTemplateColumnsSelectionDsl.UsageTemplate
import org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet
import org.jetbrains.kotlinx.dataframe.impl.columns.transform
import org.jetbrains.kotlinx.dataframe.util.COL_SELECT_DSL_CHILDREN
import org.jetbrains.kotlinx.dataframe.util.COL_SELECT_DSL_CHILDREN_REPLACE
import org.jetbrains.kotlinx.dataframe.util.COL_SELECT_DSL_CHILDREN_SINGLE_COL
import org.jetbrains.kotlinx.dataframe.util.COL_SELECT_DSL_CHILDREN_SINGLE_COL_REPLACE
import kotlin.reflect.KProperty

// region ColumnsSelectionDsl

public interface ColsInGroupsColumnsSelectionDsl {

    /**
     * ## Cols in Groups Usage
     *
     *
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `columnSet: `[ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]`<*>`
     *  
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *  `columnGroup: `[SingleColumn][org.jetbrains.kotlinx.dataframe.columns.SingleColumn]`<`[DataRow][org.jetbrains.kotlinx.dataframe.DataRow]`<*>> | `[String][String]
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     * `| `[KProperty][KProperty]`<*>` | `[ColumnPath][ColumnPath]
     *  
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *  `condition: `[ColumnFilter][org.jetbrains.kotlinx.dataframe.ColumnFilter]
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *  ### In the plain DSL:
     *
     *  
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *  [**colsInGroups**][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]` [` **`{ `**[condition][org.jetbrains.kotlinx.dataframe.documentation.UsageTemplateColumnsSelectionDsl.UsageTemplate.ConditionDef]**` }`** `]
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *  ### On a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]:
     *
     *  
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *  [columnSet][org.jetbrains.kotlinx.dataframe.documentation.UsageTemplateColumnsSelectionDsl.UsageTemplate.ColumnSetDef]
     *
     *  &nbsp;&nbsp;&nbsp;&nbsp;.[**colsInGroups**][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]` [` **`{ `**[condition][org.jetbrains.kotlinx.dataframe.documentation.UsageTemplateColumnsSelectionDsl.UsageTemplate.ConditionDef]**` }`** `]`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *  ### On a column group reference:
     *
     *  
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *  [columnGroup][org.jetbrains.kotlinx.dataframe.documentation.UsageTemplateColumnsSelectionDsl.UsageTemplate.ColumnGroupDef]
     *
     *  &nbsp;&nbsp;&nbsp;&nbsp;.[**colsInGroups**][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]` [` **`{ `**[condition][org.jetbrains.kotlinx.dataframe.documentation.UsageTemplateColumnsSelectionDsl.UsageTemplate.ConditionDef]**` }`** `]`
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */
    public interface Usage {

        /** [**colsInGroups**][ColumnsSelectionDsl.colsInGroups] */
        public interface PlainDslName

        /** .[**colsInGroups**][ColumnsSelectionDsl.colsInGroups] */
        public interface ColumnSetName

        /** .[**colsInGroups**][ColumnsSelectionDsl.colsInGroups] */
        public interface ColumnGroupName
    }

    /**
     * ## Cols in Groups
     *
     * [colsInGroups][colsInGroups] is a function that returns (optionally filtered) columns contained directly inside
     * all [column groups][ColumnGroup] in [this\]. This is useful if you want to select all columns that are
     * "one level downwards".
     *
     * #### For example:
     *
     * To get only the columns inside all column groups in a [DataFrame], you can do:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][DataFrame.select]` { `[colsInGroups][ColumnsSelectionDsl.colsInGroups]`() }`
     *
     * `df.`[select][DataFrame.select]` { `[colsInGroups][ColumnsSelectionDsl.colsInGroups]` { "user" `[in][String.contains]` it.`[name][DataColumn.name]` } }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * Similarly, you can take the columns inside all [column groups][ColumnGroup] in a [ColumnSet]:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][DataFrame.select]` { `[colGroups][ColumnsSelectionDsl.colGroups]` { "my" `[in][String.contains]` it.`[name][DataColumn.name]` }.`[colsInGroups][ColumnSet.colsInGroups]`() }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     * #### Examples of this overload:
     *
     * {@getArg [ColsInGroupsDocs.ExampleArg]}
     *
     * @see [ColumnsSelectionDsl.cols\]
     * @see [ColumnsSelectionDsl.colGroups\]
     * @param [predicate\] An optional predicate to filter the cols by.
     * @return A [TransformableColumnSet] containing the (filtered) cols.
     */
    private interface ColsInGroupsDocs {

        /** Example argument to use */
        interface ExampleArg
    }

    /**
     * ## Cols in Groups
     *
     * [colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColsInGroupsColumnsSelectionDsl.colsInGroups] is a function that returns (optionally filtered) columns contained directly inside
     * all [column groups][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup] in [this]. This is useful if you want to select all columns that are
     * "one level downwards".
     *
     * #### For example:
     *
     * To get only the columns inside all column groups in a [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], you can do:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]` { "user" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.DataColumn.name]` } }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * Similarly, you can take the columns inside all [column groups][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup] in a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colGroups]` { "my" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.DataColumn.name]` }.`[colsInGroups][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.colsInGroups]`() }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     * #### Examples of this overload:
     *
     * `df.`[select][DataFrame.select]` { `[cols][ColumnsSelectionDsl.cols]` { .. }.`[colsInGroups][ColumnSet.colsInGroups]` { "my" `[in][String.contains]` it.`[name][DataColumn.name]` } }`
     *
     * `df.`[select][DataFrame.select]` { `[colsOf][ColumnsSelectionDsl.colsOf]`<`[DataRow][DataRow]`<MyGroupType>>().`[colsInGroups][ColumnSet.colsInGroups]`() }`
     *
     * @see [ColumnsSelectionDsl.cols]
     * @see [ColumnsSelectionDsl.colGroups]
     * @param [predicate] An optional predicate to filter the cols by.
     * @return A [TransformableColumnSet][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet] containing the (filtered) cols.
     */
    public fun ColumnSet<*>.colsInGroups(predicate: ColumnFilter<*> = { true }): TransformableColumnSet<*> =
        transform { it.flatMap { it.cols().filter { predicate(it) } } }

    /**
     * ## Cols in Groups
     *
     * [colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColsInGroupsColumnsSelectionDsl.colsInGroups] is a function that returns (optionally filtered) columns contained directly inside
     * all [column groups][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup] in [this]. This is useful if you want to select all columns that are
     * "one level downwards".
     *
     * #### For example:
     *
     * To get only the columns inside all column groups in a [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], you can do:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]` { "user" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.DataColumn.name]` } }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * Similarly, you can take the columns inside all [column groups][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup] in a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colGroups]` { "my" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.DataColumn.name]` }.`[colsInGroups][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.colsInGroups]`() }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     * #### Examples of this overload:
     *
     * `df.`[select][DataFrame.select]` { `[colsInGroups][ColumnSet.colsInGroups]` { "my" `[in][String.contains]` it.`[name][DataColumn.name]` } }`
     *
     * `df.`[select][DataFrame.select]` { `[colsInGroups][ColumnSet.colsInGroups]`() }`
     *
     * @see [ColumnsSelectionDsl.cols]
     * @see [ColumnsSelectionDsl.colGroups]
     * @param [predicate] An optional predicate to filter the cols by.
     * @return A [TransformableColumnSet][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet] containing the (filtered) cols.
     */
    public fun ColumnsSelectionDsl<*>.colsInGroups(predicate: ColumnFilter<*> = { true }): TransformableColumnSet<*> =
        asSingleColumn().colsInGroups(predicate)

    /**
     * ## Cols in Groups
     *
     * [colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColsInGroupsColumnsSelectionDsl.colsInGroups] is a function that returns (optionally filtered) columns contained directly inside
     * all [column groups][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup] in [this]. This is useful if you want to select all columns that are
     * "one level downwards".
     *
     * #### For example:
     *
     * To get only the columns inside all column groups in a [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], you can do:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]` { "user" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.DataColumn.name]` } }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * Similarly, you can take the columns inside all [column groups][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup] in a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colGroups]` { "my" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.DataColumn.name]` }.`[colsInGroups][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.colsInGroups]`() }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     * #### Examples of this overload:
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup.`[colsInGroups][SingleColumn.colsInGroups]`() }`
     *
     * `df.`[select][DataFrame.select]` { myColumnGroup.`[colsInGroups][SingleColumn.colsInGroups]` { it.`[any][ColumnWithPath.any]` { it == "Alice" } } }`
     *
     * @see [ColumnsSelectionDsl.cols]
     * @see [ColumnsSelectionDsl.colGroups]
     * @param [predicate] An optional predicate to filter the cols by.
     * @return A [TransformableColumnSet][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet] containing the (filtered) cols.
     */
    public fun SingleColumn<DataRow<*>>.colsInGroups(predicate: ColumnFilter<*> = { true }): TransformableColumnSet<*> =
        ensureIsColumnGroup().allColumnsInternal().colsInGroups(predicate)

    /**
     * ## Cols in Groups
     *
     * [colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColsInGroupsColumnsSelectionDsl.colsInGroups] is a function that returns (optionally filtered) columns contained directly inside
     * all [column groups][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup] in [this]. This is useful if you want to select all columns that are
     * "one level downwards".
     *
     * #### For example:
     *
     * To get only the columns inside all column groups in a [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], you can do:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]` { "user" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.DataColumn.name]` } }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * Similarly, you can take the columns inside all [column groups][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup] in a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colGroups]` { "my" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.DataColumn.name]` }.`[colsInGroups][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.colsInGroups]`() }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     * #### Examples of this overload:
     *
     * `df.`[select][DataFrame.select]` { "myColumnGroup".`[colsInGroups][String.colsInGroups]`() }`
     *
     * @see [ColumnsSelectionDsl.cols]
     * @see [ColumnsSelectionDsl.colGroups]
     * @param [predicate] An optional predicate to filter the cols by.
     * @return A [TransformableColumnSet][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet] containing the (filtered) cols.
     */
    public fun String.colsInGroups(predicate: ColumnFilter<*> = { true }): TransformableColumnSet<*> =
        columnGroup(this).colsInGroups(predicate)

    /**
     * ## Cols in Groups
     *
     * [colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColsInGroupsColumnsSelectionDsl.colsInGroups] is a function that returns (optionally filtered) columns contained directly inside
     * all [column groups][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup] in [this]. This is useful if you want to select all columns that are
     * "one level downwards".
     *
     * #### For example:
     *
     * To get only the columns inside all column groups in a [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], you can do:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]` { "user" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.DataColumn.name]` } }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * Similarly, you can take the columns inside all [column groups][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup] in a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colGroups]` { "my" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.DataColumn.name]` }.`[colsInGroups][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.colsInGroups]`() }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     * #### Examples of this overload:
     *
     * `df.`[select][DataFrame.select]` { Type::myColumnGroup.`[colsInGroups][KProperty.colsInGroups]`() }`
     *
     * `df.`[select][DataFrame.select]` { DataSchemaType::myColumnGroup.`[colsInGroups][KProperty.colsInGroups]`() }`
     *
     * @see [ColumnsSelectionDsl.cols]
     * @see [ColumnsSelectionDsl.colGroups]
     * @param [predicate] An optional predicate to filter the cols by.
     * @return A [TransformableColumnSet][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet] containing the (filtered) cols.
     */
    public fun KProperty<*>.colsInGroups(predicate: ColumnFilter<*> = { true }): TransformableColumnSet<*> =
        columnGroup(this).colsInGroups(predicate)

    /**
     * ## Cols in Groups
     *
     * [colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColsInGroupsColumnsSelectionDsl.colsInGroups] is a function that returns (optionally filtered) columns contained directly inside
     * all [column groups][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup] in [this]. This is useful if you want to select all columns that are
     * "one level downwards".
     *
     * #### For example:
     *
     * To get only the columns inside all column groups in a [DataFrame][org.jetbrains.kotlinx.dataframe.DataFrame], you can do:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]`() }`
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colsInGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colsInGroups]` { "user" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.DataColumn.name]` } }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * Similarly, you can take the columns inside all [column groups][org.jetbrains.kotlinx.dataframe.columns.ColumnGroup] in a [ColumnSet][org.jetbrains.kotlinx.dataframe.columns.ColumnSet]:
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     * `df.`[select][org.jetbrains.kotlinx.dataframe.DataFrame.select]` { `[colGroups][org.jetbrains.kotlinx.dataframe.api.ColumnsSelectionDsl.colGroups]` { "my" `[in][String.contains]` it.`[name][org.jetbrains.kotlinx.dataframe.DataColumn.name]` }.`[colsInGroups][org.jetbrains.kotlinx.dataframe.columns.ColumnSet.colsInGroups]`() }`
     *
     * &nbsp;&nbsp;&nbsp;&nbsp;
     *
     *
     * #### Examples of this overload:
     *
     * `df.`[select][DataFrame.select]` { "pathTo"["myColumnGroup"].`[colsInGroups][ColumnPath.colsInGroups]`() }`
     *
     * @see [ColumnsSelectionDsl.cols]
     * @see [ColumnsSelectionDsl.colGroups]
     * @param [predicate] An optional predicate to filter the cols by.
     * @return A [TransformableColumnSet][org.jetbrains.kotlinx.dataframe.impl.columns.TransformableColumnSet] containing the (filtered) cols.
     */
    public fun ColumnPath.colsInGroups(predicate: ColumnFilter<*> = { true }): TransformableColumnSet<*> =
        columnGroup(this).colsInGroups(predicate)

    // region deprecated

    @Deprecated(COL_SELECT_DSL_CHILDREN, ReplaceWith(COL_SELECT_DSL_CHILDREN_REPLACE))
    public fun ColumnSet<*>.children(predicate: ColumnFilter<*> = { true }): TransformableColumnSet<*> =
        colsInGroups(predicate)

    @Deprecated(COL_SELECT_DSL_CHILDREN_SINGLE_COL, ReplaceWith(COL_SELECT_DSL_CHILDREN_SINGLE_COL_REPLACE))
    public fun SingleColumn<DataRow<*>>.children(predicate: ColumnFilter<*> = { true }): TransformableColumnSet<*> =
        ensureIsColumnGroup().colsInternal(predicate)

    @Deprecated(COL_SELECT_DSL_CHILDREN_SINGLE_COL, ReplaceWith(COL_SELECT_DSL_CHILDREN_SINGLE_COL_REPLACE))
    public fun String.children(predicate: ColumnFilter<*> = { true }): TransformableColumnSet<*> =
        columnGroup(this).children(predicate)

    @Deprecated(COL_SELECT_DSL_CHILDREN_SINGLE_COL, ReplaceWith(COL_SELECT_DSL_CHILDREN_SINGLE_COL_REPLACE))
    public fun KProperty<DataRow<*>>.children(predicate: ColumnFilter<*> = { true }): TransformableColumnSet<*> =
        columnGroup(this).children(predicate)

    @Deprecated(COL_SELECT_DSL_CHILDREN_SINGLE_COL, ReplaceWith(COL_SELECT_DSL_CHILDREN_SINGLE_COL_REPLACE))
    public fun ColumnPath.children(predicate: ColumnFilter<*> = { true }): TransformableColumnSet<*> =
        columnGroup(this).children(predicate)

    // endregion
}

// endregion
