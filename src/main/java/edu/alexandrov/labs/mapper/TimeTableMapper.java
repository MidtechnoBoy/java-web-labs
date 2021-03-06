package edu.alexandrov.labs.mapper;

import edu.alexandrov.labs.dto.TimeTableDto;
import edu.alexandrov.labs.entity.TimeTable;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(uses = LessonMapper.class)
public interface TimeTableMapper extends AbstractMapper<TimeTable, TimeTableDto> {

    @Mappings({
            @Mapping(source = "timeTableManagerDto", target = "timeTableManager"),
            @Mapping(source = "lessonDtoList", target = "lessons")
    })
    @Override
    TimeTable toEntity(TimeTableDto dto);

    @InheritInverseConfiguration
    @Override
    TimeTableDto toDto(TimeTable entity);

    @Override
    List<TimeTable> toEntityList(List<TimeTableDto> dtoList);

    @Override
    List<TimeTableDto> toDtoList(List<TimeTable> entityList);
}
