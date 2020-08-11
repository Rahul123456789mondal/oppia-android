package org.oppia.app.shim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.oppia.app.player.state.itemviewmodel.DragDropInteractionContentViewModel
import org.oppia.app.player.state.itemviewmodel.SelectionInteractionContentViewModel
import org.oppia.app.recyclerview.BindableAdapter
import org.oppia.util.parser.HtmlParser

/**
 * Extracts binding file dependencies from view files in order for Bazel to build.
 */
interface ViewBindingShim {

  fun provideProfileInputViewBindingLabelText(
    inflater: LayoutInflater,
    parent: ViewGroup,
    attachToParent: Boolean
  ): TextView

  fun provideProfileInputViewBindingInput(
    inflater: LayoutInflater,
    parent: ViewGroup,
    attachToParent: Boolean
  ): EditText

  fun provideProfileInputViewBindingErrorText(
    inflater: LayoutInflater,
    parent: ViewGroup,
    attachToParent: Boolean
  ): TextView

  fun provideSelectionInteractionViewInflatedView(
    inflater: LayoutInflater,
    parent: ViewGroup,
    attachToParent: Boolean
  ): View

  fun provideSelectionInteractionViewModel(
    view: View,
    viewModel: SelectionInteractionContentViewModel,
    htmlParserFactory: HtmlParser.Factory,
    resourceBucketName: String,
    entityType: String,
    entityId: String
  )

  fun provideMultipleChoiceInteractionItemsInflatedView(
    inflater: LayoutInflater,
    parent: ViewGroup,
    attachToParent: Boolean
  ): View

  fun provideMultipleChoiceInteractionItemsViewModel(
    view: View,
    viewModel: SelectionInteractionContentViewModel,
    htmlParserFactory: HtmlParser.Factory,
    resourceBucketName: String,
    entityType: String,
    entityId: String
  )

  fun createDragDropInteractionViewAdapter(
    adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>,
    isMultipleItemsInSamePositionAllowed: Boolean,
    isAccessibilityEnabled: Boolean,
    htmlParserFactory: HtmlParser.Factory,
    resourceBucketName: String,
    entityType: String,
    entityId: String
  ): BindableAdapter<DragDropInteractionContentViewModel>

  fun <T> createDragDropInteractionViewNestedAdapter(
    htmlParserFactory: HtmlParser.Factory,
    resourceBucketName: String,
    entityType: String,
    entityId: String
  ): BindableAdapter<String>

  fun getDefaultRegion(parentView: FrameLayout): View
}
