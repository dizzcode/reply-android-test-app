package dizzcode.com.reply.test

import androidx.activity.ComponentActivity
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import dizzcode.com.reply.ui.ReplyApp
import org.junit.Rule
import org.junit.Test

class ReplyAppTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    @TestCompactWidth
    fun compactDevice_verifyUsingBottomNavigation() {
        // Set up compact window
        /**
         * Note
         * Adding a composable that accepts WindowWidthSizeClass as an argument is a good practice to make testable code.
         */
        composeTestRule.setContent {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Compact
            )
        }

        // Bottom navigation is displayed
        composeTestRule.onNodeWithTag(
            "Navigation Bottom"
        ).assertExists()
    }


    @Test
    @TestMediumWidth
    fun mediumDevice_verifyUsingNavigationRail() {
        // Set up medium window
        composeTestRule.setContent {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Medium
            )
        }
        // Navigation rail is displayed
//        composeTestRule.onNodeWithTagForStringId(
//            R.string.navigation_rail
//        ).assertExists()
        composeTestRule.onNodeWithTag(
            "Navigation Rail"
        ).assertExists()
    }



    @Test
    @TestExpandedWidth
    fun expandedDevice_verifyUsingNavigationDrawer() {
        // Set up expanded window
        composeTestRule.setContent {
            ReplyApp(
                windowSize = WindowWidthSizeClass.Expanded
            )
        }
        // Navigation drawer is displayed
        composeTestRule.onNodeWithTag(
            "Navigation Drawer"
        ).assertExists()
    }

}
