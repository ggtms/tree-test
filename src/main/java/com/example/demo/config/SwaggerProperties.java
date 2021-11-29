package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.util.List;

/**
 * @author txl
 * @description
 * @date 2021/8/19 10:11
 */
@ConfigurationProperties(prefix = "knife4j")
public class SwaggerProperties {

    private boolean enable;
    private String groupName;
    private String contactEmail;
    private String contactName;
    private String contactUrl;
    private String description;
    private String title;
    private String url;
    private String version;
    @NestedConfigurationProperty
    private List<ParameterConfig> parameterConfig;

    public SwaggerProperties() {
    }

    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getContactEmail() {
        return this.contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactName() {
        return this.contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactUrl() {
        return this.contactUrl;
    }

    public void setContactUrl(String contactUrl) {
        this.contactUrl = contactUrl;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<SwaggerProperties.ParameterConfig> getParameterConfig() {
        return this.parameterConfig;
    }

    public void setParameterConfig(List<SwaggerProperties.ParameterConfig> parameterConfig) {
        this.parameterConfig = parameterConfig;
    }

    public static class ParameterConfig {
        private String name;
        private String description;
        private String type = "head";
        private String dataType = "String";
        private boolean required;
        private String defaultValue;

        public ParameterConfig() {
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getType() {
            return this.type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDataType() {
            return this.dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public boolean isRequired() {
            return this.required;
        }

        public void setRequired(boolean required) {
            this.required = required;
        }

        public String getDefaultValue() {
            return this.defaultValue;
        }

        public void setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
        }
    }
}
