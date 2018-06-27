package com.schibsted.spain.barista.sample;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.schibsted.spain.barista.assertion.BaristaRecyclerViewAssertions.assertDisplayedAtPosition;
import static com.schibsted.spain.barista.assertion.BaristaRecyclerViewAssertions.assertRecyclerViewItemCount;

@RunWith(AndroidJUnit4.class)
public class RecyclerViewAssertionsTest {

  @Rule
  public ActivityTestRule<ListsActivity> activity = new ActivityTestRule<>(ListsActivity.class, true, false);

  @Before
  public void setUp() throws Exception {
    launchTestActivity(ListsActivity.buildIntent()
        .withRecyclers(R.id.recycler)
    );
  }

  @Test
  public void shouldHaveFourEntriesInRecyclerView() {
    assertRecyclerViewItemCount(R.id.recycler, ListsActivity.FRUITS.length);
  }

  @Test
  public void shouldFindItemInRecyclerViewWithoutId() {
    assertDisplayedAtPosition(R.id.recycler, 20, ListsActivity.FRUITS[20]);
  }

  @Test
  public void shouldFindItemInRecyclerViewWithId() {
    assertDisplayedAtPosition(R.id.recycler, 20, R.id.textview, ListsActivity.FRUITS[20]);
  }

  private void launchTestActivity(ListsActivity.IntentBuilder intentBuilder) {
    activity.launchActivity(intentBuilder.build(InstrumentationRegistry.getTargetContext()));
  }
}
