package cordelia.rpc;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
@ReqMethod(value = "torrent-add", answer = RsTorrentGet.class)
public final class RqTorrentAdd implements RqArguments {

    private String cookies;
    @JsonProperty("download-dir")
    private String downloadDir;
    private String filename;
    private List<String> labels;
    private String metainfo;
    private Boolean paused;
    @JsonProperty("peer-limit")
    private Integer peerLimit;
    private Integer bandwidthPriority;
    @JsonProperty("files-wanted")
    private List<Integer> filesWanted;
    @JsonProperty("files-unwanted")
    private List<Integer> filesUnwanted;
    @JsonProperty("priority-high")
    private List<Integer> priorityHigh;
    @JsonProperty("priority-low")
    private List<Integer> priorityLow;
    @JsonProperty("priority-normal")
    private List<Integer> priorityNormal;

}
