/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.cassandra.distributed.shared;

import com.vdurmont.semver4j.Semver;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VersionsTest
{

    @Test
    public void testGet()
    {
        Versions.find().get("2.2.2");
    }

    @Test
    public void testGetLatest()
    {
        Versions.find().getLatest(new Semver("2.2.0"));
        Versions.find().getLatest(new Semver("2.2", Semver.SemverType.LOOSE));
    }

    @Test
    public void testFind()
    {
        Versions versions = Versions.find();
        assertThat(versions).isNotNull();

    }

    @Test
    public void testToURL()
    {
        assertThat(Versions.getClassPath()).isNotEmpty();
    }

}
