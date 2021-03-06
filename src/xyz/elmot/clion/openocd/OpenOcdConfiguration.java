package xyz.elmot.clion.openocd;

import com.intellij.execution.Executor;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.project.Project;
import com.jetbrains.cidr.cpp.execution.CMakeAppRunConfiguration;
import com.jetbrains.cidr.execution.CidrCommandLineState;
import com.jetbrains.cidr.execution.CidrExecutableDataHolder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * (c) elmot on 29.9.2017.
 */
@SuppressWarnings("WeakerAccess")
public class OpenOcdConfiguration extends CMakeAppRunConfiguration implements CidrExecutableDataHolder {


    @SuppressWarnings("WeakerAccess")
    public OpenOcdConfiguration(Project project, ConfigurationFactory configurationFactory, String targetName) {
        super(project, configurationFactory, targetName);
    }

    @Nullable
    @Override
    public CidrCommandLineState getState(@NotNull Executor executor, @NotNull ExecutionEnvironment environment) {
        return new CidrCommandLineState(environment, new OpenOcdLauncher(this));
    }

}
