package Serialisation.CustomJacksonSerialization;

/*@JsonSerialize(using = LinkSerializer.class)
@JsonDeserialize(using = LinkDeserializer.class)
@Produces({"application/json","application/xml"})*/
public class Link {
    private String rel;
    private String href;
}
