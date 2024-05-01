package climbers.models.climbing;

import climbers.models.climber.Climber;
import climbers.models.mountain.Mountain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClimbingImpl implements Climbing {
  private int climbedMountainsCnt;
  private int removedClimbers;

  public ClimbingImpl() {
    this.climbedMountainsCnt = 0;
    this.removedClimbers = 0;
  }

  @Override
  public void conqueringPeaks(Mountain mountain, Collection<Climber> climbers) {
    this.setRemovedClimbersToZero();
    this.increaseMountainsCount();

    List<String> peaks = new ArrayList<>(mountain.getPeaksList());

    for (Climber climber : climbers) {
      while (climber.canClimb() && peaks.size() > 0) {
        climber.climb();
        climber.getRoster().getPeaks().add(peaks.remove(0));

        if (!climber.canClimb()) {
          this.removedClimbers++;
        }
      }
    }
  }

  @Override
  public int getClimbedMountainsCnt() {
    return this.climbedMountainsCnt;
  }

  @Override
  public int getRemovedClimbers() {
    return this.removedClimbers;
  }

  public void setRemovedClimbersToZero() {
    this.removedClimbers = 0;
  }

  public void increaseMountainsCount() {
    this.climbedMountainsCnt++;
  }
}
