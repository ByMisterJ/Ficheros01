package org.example.MapeoJson.APIsJson;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class todos {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}
