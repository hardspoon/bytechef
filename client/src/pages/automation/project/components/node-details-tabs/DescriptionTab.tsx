import Input from 'components/Input/Input';
import TextArea from 'components/TextArea/TextArea';
import {ComponentDefinitionModel} from 'middleware/hermes/configuration';

const DescriptionTab = ({component}: {component: ComponentDefinitionModel}) => (
    <div className="h-full flex-[1_1_1px] overflow-auto p-4">
        <Input
            key={`${component.name}_componentDescriptionName`}
            label="Name"
            labelClassName="px-2"
            name="componentDescriptionName"
            defaultValue={component.title}
        />

        <TextArea
            key={`${component.name}_nodeDescription`}
            label="Description"
            labelClassName="px-2"
            name="nodeDescription"
            placeholder="Write some notes for yourself..."
        />
    </div>
);

export default DescriptionTab;
