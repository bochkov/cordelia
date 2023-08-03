package cordelia.rpc;

import com.fasterxml.jackson.annotation.JsonProperty;
import cordelia.rpc.types.Stats;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public final class RsSessionStats implements RsArguments {

    private Long activeTorrentCount;
    private Long downloadSpeed;
    private Long pausedTorrentCount;
    private Long torrentCount;
    private Long uploadSpeed;

    @JsonProperty("cumulative-stats")
    private Stats cumulativeStats;

    @JsonProperty("current-stats")
    private Stats currentStats;

}
